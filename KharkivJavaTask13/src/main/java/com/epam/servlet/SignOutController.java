package com.epam.servlet;

import com.epam.constans.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-out")
public class SignOutController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().removeAttribute(Constants.CURRENT_ACCOUNT);
        req.getSession().invalidate();
        resp.sendRedirect(Constants.MAIN_PAGE);
    }
}
