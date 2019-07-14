package com.epam.servlet;

import com.epam.captcha.CaptchaHandler;
import com.epam.creator.ImageCreator;
import com.epam.entity.User;
import com.epam.service.CaptchaService;
import com.epam.service.UserService;
import com.epam.utils.Constants;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/registration")
@MultipartConfig
public class RegistrationController extends HttpServlet {

    private UserService userService;
    private CaptchaService captchaService;
    private CaptchaHandler captchaHandler;
    private ImageCreator imageCreator;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute(Constants.USER_SERVICE);
        captchaService = (CaptchaService) servletContext.getAttribute(Constants.CAPTCHA_SERVICE);
        captchaHandler = (CaptchaHandler) servletContext.getAttribute(Constants.CAPTCHA_PRESERVER);
        imageCreator = (ImageCreator) servletContext.getAttribute(Constants.IMAGE_CREATOR);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("userEmail");
        if (userService.isUserPresent(login) || !captchaService.checkValid(req, captchaHandler)) {
            saveInfo(req);
            req.getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, resp);
        } else {
            imageCreator.loadAndSaveImage(req.getPart(Constants.IMAGE_PARAMETER_NAME));
            createNewUser(req);
            req.getRequestDispatcher(Constants.MAIN_PAGE).forward(req, resp);
        }
    }

    private void createNewUser(HttpServletRequest req) {
        Optional<User> userOptional = userService.addNewUser(req);
        userOptional.ifPresent(value -> req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, value));
    }

    private void saveInfo(HttpServletRequest req) {
        req.setAttribute("name", req.getParameter("userName"));
        req.setAttribute("surName", req.getParameter("userSurname"));
        req.setAttribute("login", req.getParameter("userEmail"));
        req.setAttribute("password", req.getParameter("userPassword"));
    }
}
