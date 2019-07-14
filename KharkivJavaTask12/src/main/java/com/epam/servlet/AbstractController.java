package com.epam.servlet;

import com.epam.captcha.CaptchaHandler;
import com.epam.service.CaptchaService;
import com.epam.service.UserService;
import com.epam.utils.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {
    private UserService userService;
    private CaptchaService captchaService;
    private CaptchaHandler captchaHandler;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        userService = (UserService) servletContext.getAttribute(Constants.USER_SERVICE);
        captchaService = (CaptchaService) servletContext.getAttribute(Constants.CAPTCHA_SERVICE);
        captchaHandler = (CaptchaHandler) servletContext.getAttribute(Constants.CAPTCHA_PRESERVER);
    }

    protected UserService getUserService() {
        return userService;
    }

    protected CaptchaService getCaptchaService() {
        return captchaService;
    }

    protected CaptchaHandler getCaptchaHandler() {
        return captchaHandler;
    }
}
