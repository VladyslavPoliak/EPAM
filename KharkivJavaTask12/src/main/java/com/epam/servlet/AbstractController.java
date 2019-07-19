package com.epam.servlet;

import com.epam.captcha.CaptchaHandler;
import com.epam.constans.Constants;
import com.epam.creator.ImageCreator;
import com.epam.form.SearchForm;
import com.epam.service.CaptchaService;
import com.epam.service.CarService;
import com.epam.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public abstract class AbstractController extends HttpServlet {

    protected final Logger LOGGER = Logger.getLogger(getClass());
    private final String DEFAULT_COUNT = "6";
    private UserService userService;
    private CaptchaService captchaService;
    private CarService carService;

    private CaptchaHandler captchaHandler;

    private ImageCreator imageCreator;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        userService = (UserService) servletContext.getAttribute(Constants.USER_SERVICE);
        captchaService = (CaptchaService) servletContext.getAttribute(Constants.CAPTCHA_SERVICE);
        carService = (CarService) servletContext.getAttribute(Constants.CAR_SERVICE);
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

    protected CarService getCarService() {
        return carService;
    }

    protected final SearchForm createSearchForm(HttpServletRequest request) {
        return new SearchForm(request.getParameter("searchByName"),
                request.getParameterValues("producers"),
                request.getParameterValues("classes"),
                request.getParameter("minPrice"),
                request.getParameter("maxPrice")
        );
    }

    protected String getNumberOfDisplayedCars(HttpServletRequest request) {
        String count = request.getParameter("count-cars");
        if (count == null) {
            return DEFAULT_COUNT;
        }
        return count;
    }
}
