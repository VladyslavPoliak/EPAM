package com.epam.servlet;

import com.epam.entity.User;
import com.epam.service.UserService;
import com.epam.utils.Constants;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserService userService;
    private final Logger LOGGER = Logger.getLogger(LoginController.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute(Constants.USER_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("email-login");
        String pass = req.getParameter("password-login");
        Optional<User> optionalUser = userService.getUserByEmailAndPass(login, pass);
        if (optionalUser.isPresent()) {
            LOGGER.info("user " + optionalUser.get().getDescription() + " logged in");
            req.getSession().setAttribute(Constants.CURRENT_ACCOUNT,optionalUser.get());
            resp.sendRedirect(Constants.MAIN_PAGE);
        } else {
            req.getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, resp);
        }
    }
}
