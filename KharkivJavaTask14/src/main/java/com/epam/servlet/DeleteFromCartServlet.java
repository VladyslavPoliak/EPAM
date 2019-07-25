package com.epam.servlet;

import com.epam.constans.Constants;
import com.epam.entity.Car;
import com.epam.model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/deleteFromCart")
public class DeleteFromCartServlet extends AbstractController {

    public static final Logger LOGGER = Logger.getLogger(DeleteFromCartServlet.class.getName());
    private static final long serialVersionUID = 8956105311512250143L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car = getCarService().getCarById(Integer.parseInt(request.getParameter("id")));
        ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART);
        shoppingCart.removeCar(car.getId());
    }
}
