package com.epam.servlet;

import com.epam.captcha.CaptchaHandler;
import com.epam.entity.Captcha;
import com.epam.sender.CaptchaSender;
import com.epam.service.CaptchaService;
import com.epam.utils.Constants;

import javax.naming.directory.NoSuchAttributeException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CaptchaServlet")
public class CaptchaServlet extends HttpServlet {

    private CaptchaService captchaService;
    private CaptchaHandler captchaHandler;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        captchaService = (CaptchaService) context.getAttribute(Constants.CAPTCHA_SERVICE);
        captchaHandler = (CaptchaHandler) context.getAttribute(Constants.CAPTCHA_HANDLER);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  captchaService.removeOldCaptcha();
        getSenderWithNewCaptcha(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        captchaService.removeOldCaptcha();
        getSenderWithNewCaptcha(req, resp);
        if (captchaService.checkValid(req, captchaHandler)) {
            GoToMainPage(req, resp);
        } else {
            returnToRegistrationByInvalidCaptcha(req, resp);
        }
    }

    private void GoToMainPage(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher(Constants.PAGE_FOLDER + Constants.MAIN_JSP).forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void returnToRegistrationByInvalidCaptcha(HttpServletRequest request, HttpServletResponse response) {
        getSenderWithNewCaptcha(request, response)
                .setCaptcha(Boolean.TRUE)
                .send();
        try {
            request.getRequestDispatcher(Constants.PAGE_FOLDER + Constants.REGISTRATION_JSP).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private CaptchaSender getSenderWithNewCaptcha(HttpServletRequest request, HttpServletResponse response) {
        CaptchaSender sender = new CaptchaSender(request, response);
        try {
            Captcha captcha = captchaService.create();
            captchaHandler.addCaptcha(request, response, captcha);
            sender.setCaptchaId(captcha.getId());
        } catch (NoSuchAttributeException e) {
            e.printStackTrace();
        }
        return sender;
    }
}
