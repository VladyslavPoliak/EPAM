package com.epam.servlet;

import com.epam.creator.CaptchaCreator;
import com.epam.entity.Captcha;
import com.epam.sender.CaptchaSender;
import com.epam.service.CaptchaService;

import javax.imageio.ImageIO;
import javax.naming.directory.NoSuchAttributeException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/captcha")
public class CaptchaController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CaptchaService captchaService = getCaptchaService();
        captchaService.removeExpiredCaptcha();
        getSenderWithNewCaptcha(req, resp, captchaService).send();
    }

    private CaptchaSender getSenderWithNewCaptcha(HttpServletRequest request, HttpServletResponse response, CaptchaService captchaService) {
        CaptchaSender sender = new CaptchaSender(request);
        try {
            CaptchaCreator captchaCreator = captchaService.create();
            BufferedImage bufferedImage = captchaService.getBufferedImage(captchaCreator);
            ServletOutputStream stream = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpg", stream);
            stream.close();
            Captcha captcha = captchaService.createCaptcha(captchaCreator.getCaptchaNumbers());
            getCaptchaHandler().addCaptcha(request, response, captcha);
            sender.setCaptchaId(captcha.getId());
        } catch (NoSuchAttributeException | IOException e) {
            e.printStackTrace();
        }
        return sender;
    }
}
