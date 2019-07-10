package com.epam.servlet;

import com.epam.captcha.CaptchaHandler;
import com.epam.creator.CaptchaCreator;
import com.epam.entity.Captcha;
import com.epam.sender.CaptchaSender;
import com.epam.service.CaptchaService;
import com.epam.utils.Constants;

import javax.imageio.ImageIO;
import javax.naming.directory.NoSuchAttributeException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/CaptchaServlet")
public class CaptchaServlet extends HttpServlet {

    private CaptchaService captchaService;
    private CaptchaHandler captchaHandler;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        captchaService = (CaptchaService) context.getAttribute(Constants.CAPTCHA_SERVICE);
        captchaHandler = (CaptchaHandler) context.getAttribute(Constants.CAPTCHA_PRESERVER);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        captchaService.removeOldCaptcha();
        getSenderWithNewCaptcha(req, resp).send();
    }

    private CaptchaSender getSenderWithNewCaptcha(HttpServletRequest request, HttpServletResponse response) {
        CaptchaSender sender = new CaptchaSender(request, response);
        try {
            CaptchaCreator captchaCreator = captchaService.create();
            BufferedImage bufferedImage = captchaService.bufferedImage(captchaCreator);
            ServletOutputStream stream = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpg", stream);
            stream.close();
            Captcha captcha = captchaService.createCaptcha(captchaCreator.getCaptchaNumbers());
            captchaHandler.addCaptcha(request, response, captcha);
            sender.setCaptchaId(captcha.getId());
        } catch (NoSuchAttributeException | IOException e) {
            e.printStackTrace();
        }
        return sender;
    }
}
