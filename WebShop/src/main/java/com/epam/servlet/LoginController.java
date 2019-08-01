package com.epam.servlet;

import com.epam.constans.Constants;
import com.epam.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("email-login");
        String pass = req.getParameter("password-login");
        Optional<User> optionalUser = getUserService().getUserByEmailAndPass(login, pass);
        if (optionalUser.isPresent()) {
            LOGGER.info("user " + optionalUser.get().getDescription() + " logged in");
            req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, optionalUser.get());
            resp.sendRedirect(Constants.MAIN_PAGE);
        } else {
            req.getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, resp);
        }
    }
}