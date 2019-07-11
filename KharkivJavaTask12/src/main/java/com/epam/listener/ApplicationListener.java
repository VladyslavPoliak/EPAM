package com.epam.listener;

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
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebListener
public class ApplicationListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(ApplicationListener.class);
    private final Properties applicationProperties = new Properties();
    private BasicDataSource dataSource;

    private UserContainer container = new UserContainer();

    private UserDao userDao;
    private CaptchaDao captchaDao;
    private UserService userService;
    private CaptchaService captchaService;
    private CaptchaHandler handler;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        loadApplicationProperties();
        initDao();
        initServices();
        ServletContext context = sce.getServletContext();

        String handlerName = context.getInitParameter(Constants.CAPTCHA_HANDLER);
        handler = new CaptchaHandlerContainer().getCaptchaHandler(handlerName);
        setAttributeInServletContext(context);

        dataSource = initDataSource();

    }

    private BasicDataSource initDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDefaultAutoCommit(false);
        dataSource.setRollbackOnReturn(true);
        dataSource.setDriverClassName(getApplicationProperty("db.driver"));
        dataSource.setUrl(getApplicationProperty("db.url"));
        dataSource.setUsername(getApplicationProperty("db.username"));
        dataSource.setPassword(getApplicationProperty("db.password"));
        dataSource.setInitialSize(Integer.parseInt(getApplicationProperty("db.pool.initSize")));
        dataSource.setMaxTotal(Integer.parseInt(getApplicationProperty("db.pool.maxSize")));
        LOGGER.info("dataSource created");
        return dataSource;
    }

    private String getApplicationProperty(String key) {
        return applicationProperties.getProperty(key);
    }

    private void setAttributeInServletContext(ServletContext context) {
        context.setAttribute(Constants.USER_SERVICE, userService);
        context.setAttribute(Constants.CAPTCHA_SERVICE, captchaService);
        context.setAttribute(Constants.CAPTCHA_PRESERVER, handler);
    }

    private void initServices() {
        userService = new UserServiceImpl(userDao);
        captchaService = new CaptchaServiceImpl(captchaDao);
    }

    private void initDao() {
        userDao = new UserDaoImpl(container.getUserList());
        captchaDao = new CaptchaDaoImpl();
    }

    private void loadApplicationProperties() {
        try (InputStream in = ApplicationListener.class.getClassLoader().
                getResourceAsStream("application.properties")) {
            applicationProperties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}