package com.epam.servlet;

import com.epam.service.UserService;
import com.epam.utils.Constants;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class Registration extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute(Constants.USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("userEmail");
        if (userService.isUserPresent(login)) {
            saveInfo(req);
            req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/main");
        }
    }

    private void saveInfo(HttpServletRequest req) {
        req.setAttribute("name", req.getParameter("userName"));
        req.setAttribute("surName", req.getParameter("userSurname"));
        req.setAttribute("login", req.getParameter("userEmail"));
    }
}
