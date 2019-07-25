package com.epam.servlet;

import com.epam.captcha.CaptchaHandler;
import com.epam.constans.Constants;
import com.epam.creator.ImageCreator;
import com.epam.form.SearchForm;
import com.epam.service.CaptchaService;
import com.epam.service.CarService;
import com.epam.service.OrderService;
import com.epam.service.UserService;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController extends HttpServlet {

    private static final long serialVersionUID = -8500388645920950957L;
    final Logger LOGGER = Logger.getLogger(getClass());
    final int DEFAULT_CAR_PER_PAGE = 6;

    private UserService userService;
    private CaptchaService captchaService;
    private CarService carService;
    private OrderService orderService;

    private CaptchaHandler captchaHandler;

    private ImageCreator imageCreator;


     static void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage", jspPage);
        req.getRequestDispatcher("page-template.jsp").forward(req, resp);
    }

     static void sendJSON(JSONObject object, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.getWriter().println(object.toString());
        resp.getWriter().close();
    }

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        userService = (UserService) servletContext.getAttribute(Constants.USER_SERVICE);
        captchaService = (CaptchaService) servletContext.getAttribute(Constants.CAPTCHA_SERVICE);
        carService = (CarService) servletContext.getAttribute(Constants.CAR_SERVICE);
        orderService = (OrderService) servletContext.getAttribute(Constants.ORDER_SERVICE);
        captchaHandler = (CaptchaHandler) servletContext.getAttribute(Constants.CAPTCHA_PRESERVER);
        imageCreator = (ImageCreator) servletContext.getAttribute(Constants.IMAGE_CREATOR);
    }

    UserService getUserService() {
        return userService;
    }

    CaptchaService getCaptchaService() {
        return captchaService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    CaptchaHandler getCaptchaHandler() {
        return captchaHandler;
    }

    ImageCreator getImageCreator() {
        return imageCreator;
    }

    CarService getCarService() {
        return carService;
    }

    final SearchForm createSearchForm(HttpServletRequest request) {
        return new SearchForm(request.getParameter("searchByName"),
                request.getParameterValues("producers"),
                request.getParameterValues("classes"),
                request.getParameter("minPrice"),
                request.getParameter("maxPrice")
        );
    }

    final int getOffset(HttpServletRequest req) {
        String val = req.getParameter("page");
        if (val != null) {
            int page = Integer.parseInt(val);
            return (page - 1) * getCountPerPage(req);
        } else {
            return 0;
        }
    }

    int getCountPerPage(HttpServletRequest request) {
        String count = request.getParameter("count");
        if (count == null) {
            return DEFAULT_CAR_PER_PAGE;
        }
        return Integer.parseInt(count);
    }
}
