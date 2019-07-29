package com.epam.servlet;

import com.epam.constans.Constants;
import com.epam.entity.Car;
import com.epam.model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addToCart")
public class AddToCartController extends AbstractController {

    private static final long serialVersionUID = 143951577571711026L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = getCarService().getCarById(Integer.parseInt(req.getParameter("id")));
        ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART);
        shoppingCart.addCar(car, 1);
    }

}
