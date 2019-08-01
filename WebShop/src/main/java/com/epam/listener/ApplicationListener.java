package com.epam.listener;

import com.epam.captcha.CaptchaHandler;
import com.epam.constans.Constants;
import com.epam.container.CaptchaContainer;
import com.epam.container.CaptchaHandlerContainer;
import com.epam.creator.ImageCreator;
import com.epam.database.DataBaseManager;
import com.epam.locale.LocaleStrategy;
import com.epam.locale.LocaleStrategyContainer;
import com.epam.parser.PermissionEvaluator;
import com.epam.parser.PermissionEvaluatorImpl;
import com.epam.parser.SecurityProperties;
import com.epam.parser.XMLParser;
import com.epam.repository.CarRepository;
import com.epam.repository.OrderRepository;
import com.epam.repository.UserRepository;
import com.epam.repository.impl.CarRepositoryImpl;
import com.epam.repository.impl.OrderRepositoryImpl;
import com.epam.repository.impl.UserRepositoryImpl;
import com.epam.service.CaptchaService;
import com.epam.service.CarService;
import com.epam.service.OrderService;
import com.epam.service.UserService;
import com.epam.service.impl.CaptchaServiceImpl;
import com.epam.service.impl.CarServiceImpl;
import com.epam.service.impl.OrderServiceImpl;
import com.epam.service.impl.UserServiceImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@WebListener
public class ApplicationListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(ApplicationListener.class);
    private final Properties applicationProperties = new Properties();
    private BasicDataSource dataSource;
    private DataBaseManager dataBaseManager;

    private CaptchaContainer captchaContainer;

    private UserRepository userRepository;
    private CarRepository carRepository;
    private OrderRepository orderRepository;

    private UserService userService;
    private CaptchaService captchaService;
    private CarService carService;
    private OrderService orderService;

    private CaptchaHandler handler;
    private String handlerName;
    private ImageCreator imageCreator;

    private String storageFolderPath;
    private String defaultAvatarPath;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        loadApplicationProperties();
        dataSource = initDataSource();
        initDataBaseManager();
        initRepositories();
        initContainer();

        initServices();
        ServletContext context = sce.getServletContext();

        getInitOptions(context);
        imageCreator = new ImageCreator(storageFolderPath, defaultAvatarPath);

        handler = new CaptchaHandlerContainer().getCaptchaHandler(handlerName);
        setAttributeInServletContext(context);


        LocaleStrategyContainer localeStrategyContainer = new LocaleStrategyContainer();
        String localeStrategy = context.getInitParameter("localeStrategy");
        LocaleStrategy localeStrategy1 = localeStrategyContainer.get(localeStrategy);
        context.setAttribute("localeStrategy", localeStrategy1);

        String s = context.getInitParameter("supportedLocales");
        List<String> supportedLocales = Arrays.asList(s.split(" "));
        context.setAttribute("supportedLocales", supportedLocales);

        File file = new File(context.getRealPath("WEB-INF/security.xml"));

        XMLParser parser = new XMLParser();
        SecurityProperties properties = parser.parse(file);
        PermissionEvaluator permissionEvaluator = new PermissionEvaluatorImpl(properties);
        context.setAttribute("permissionEvaluator", permissionEvaluator);


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            dataSource.close();
        } catch (SQLException e) {
            LOGGER.error("Data Source not closed");
        }
        LOGGER.info("Web application destroyed");
    }

    private void initContainer() {
        captchaContainer = new CaptchaContainer();
    }


    private void getInitOptions(ServletContext context) {
        handlerName = context.getInitParameter(Constants.CAPTCHA_HANDLER);
        storageFolderPath = context.getInitParameter(Constants.STORAGE_FOLDER_PATH);
        defaultAvatarPath = context.getInitParameter(Constants.DEFAULT_AVATAR);
    }

    private void initRepositories() {
        userRepository = new UserRepositoryImpl(dataBaseManager);
        carRepository = new CarRepositoryImpl(dataBaseManager);
        orderRepository = new OrderRepositoryImpl(dataBaseManager);
    }

    private void initServices() {
        userService = new UserServiceImpl(userRepository);
        captchaService = new CaptchaServiceImpl(captchaContainer);
        carService = new CarServiceImpl(carRepository);
        orderService = new OrderServiceImpl(orderRepository);
    }

    private String getApplicationProperty(String key) {
        return applicationProperties.getProperty(key);
    }

    private void setAttributeInServletContext(ServletContext context) {
        context.setAttribute(Constants.USER_SERVICE, userService);
        context.setAttribute(Constants.CAPTCHA_SERVICE, captchaService);
        context.setAttribute(Constants.CAR_SERVICE, carService);
        context.setAttribute(Constants.ORDER_SERVICE, orderService);

        context.setAttribute(Constants.CAPTCHA_PRESERVER, handler);
        context.setAttribute(Constants.IMAGE_CREATOR, imageCreator);
        context.setAttribute(Constants.DEFAULT_AVATAR, defaultAvatarPath);
        context.setAttribute(Constants.STORAGE_FOLDER_PATH, storageFolderPath);

        context.setAttribute(Constants.CLASSES_LIST, carService.getAllClasses());
        context.setAttribute(Constants.MARKS_LIST, carService.getAllMarks());
    }

    private void loadApplicationProperties() {
        try (InputStream in = ApplicationListener.class.getClassLoader().
                getResourceAsStream(Constants.APPLICATION_PROPERTIES)) {
            applicationProperties.load(in);
        } catch (IOException e) {
            LOGGER.error("properties was not load " + e);
        }
    }

    private void initDataBaseManager() {
        try {
            dataBaseManager = new DataBaseManager(dataSource.getConnection());
        } catch (SQLException e) {
            LOGGER.error("Connection was not open " + e);
        }
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
}
