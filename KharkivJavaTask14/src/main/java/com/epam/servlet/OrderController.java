package com.epam.servlet;

import com.epam.constans.Constants;
import com.epam.entity.User;
import com.epam.model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order")
public class OrderController extends AbstractController {

    private static final long serialVersionUID = -1782066337808445826L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART);
        User user = (User) getServletContext().getAttribute(Constants.CURRENT_ACCOUNT);
        getOrderService().makeOrder(shoppingCart, user);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
