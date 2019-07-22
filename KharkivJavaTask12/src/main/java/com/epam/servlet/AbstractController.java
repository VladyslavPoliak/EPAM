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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController extends HttpServlet {

    protected final Logger LOGGER = Logger.getLogger(getClass());
    private final int DEFAULT_COUNT = 6;
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

    public final int getOffset(HttpServletRequest req) {
        int limit= getNumberOfDisplayedCars(req);
        String val = req.getParameter("page");
        if (val != null) {
            int page = Integer.parseInt(val);
            return (page - 1) * limit;
        } else {
            return 0;
        }
    }

    protected int getNumberOfDisplayedCars(HttpServletRequest request) {
        String count = request.getParameter("count-cars");
        if (count == null) {
            return DEFAULT_COUNT;
        }
        return Integer.parseInt(count);
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

    public static void forwardToFragment(String jspFragment, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/JSP/fragment/" + jspFragment).forward(req, resp);
    }

    public static void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage", jspPage);
        req.setAttribute("currentServlet", req.getRequestURI());
        req.getRequestDispatcher("page-template.jsp").forward(req, resp);
    }

    public static void redirect(String url, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(url);
    }
}
