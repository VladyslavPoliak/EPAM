package com.epam.listener;

import com.epam.Constants;
import com.epam.container.UserContainer;
import com.epam.dao.UserDao;
import com.epam.dao.impl.UserDaoImpl;
import com.epam.service.UserService;
import com.epam.service.impl.UserServiceImpl;

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

        sce.getServletContext().setAttribute(Constants.USER_SERVICE, userService);
    }
}
