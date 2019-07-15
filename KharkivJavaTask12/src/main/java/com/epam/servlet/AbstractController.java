package com.epam.servlet;

import com.epam.captcha.CaptchaHandler;
import com.epam.creator.ImageCreator;
import com.epam.service.CaptchaService;
import com.epam.service.UserService;
import com.epam.utils.Constants;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

    protected final Logger LOGGER = Logger.getLogger(getClass());
    private UserService userService;
    private CaptchaService captchaService;
    private CaptchaHandler captchaHandler;

    private ImageCreator imageCreator;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        userService = (UserService) servletContext.getAttribute(Constants.USER_SERVICE);
        captchaService = (CaptchaService) servletContext.getAttribute(Constants.CAPTCHA_SERVICE);
        captchaHandler = (CaptchaHandler) servletContext.getAttribute(Constants.CAPTCHA_PRESERVER);
        imageCreator = (ImageCreator) servletContext.getAttribute(Constants.IMAGE_CREATOR);
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

    protected ImageCreator getImageCreator() {
        return imageCreator;
    }
}