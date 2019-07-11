package com.epam.listener;

import org.apache.commons.dbcp2.BasicDataSource;

import com.epam.captcha.CaptchaHandler;
import com.epam.container.CaptchaHandlerContainer;
import com.epam.container.UserContainer;
import com.epam.dao.CaptchaDao;
import com.epam.dao.UserDao;
import com.epam.dao.impl.CaptchaDaoImpl;
import com.epam.dao.impl.UserDaoImpl;
import com.epam.service.CaptchaService;
import com.epam.service.UserService;
import com.epam.service.impl.CaptchaServiceImpl;
import com.epam.service.impl.UserServiceImpl;
import com.epam.utils.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        UserContainer container = new UserContainer();

        UserDao userDao = new UserDaoImpl(container.getUserList());
        UserService userService = new UserServiceImpl(userDao);

        CaptchaDao captchaDao = new CaptchaDaoImpl();
        CaptchaService captchaService = new CaptchaServiceImpl(captchaDao);

        sce.getServletContext().setAttribute(Constants.USER_SERVICE, userService);
        sce.getServletContext().setAttribute(Constants.CAPTCHA_SERVICE, captchaService);

        ServletContext context = sce.getServletContext();

        String handlerName = context.getInitParameter(Constants.CAPTCHA_HANDLER);
        CaptchaHandler handler = new CaptchaHandlerContainer().getCaptchaHandler(handlerName);
        context.setAttribute(Constants.CAPTCHA_PRESERVER, handler);
    }
}
