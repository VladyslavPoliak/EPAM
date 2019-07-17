package com.epam.servlet;

import com.epam.entity.Car;
import com.epam.utils.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class AllCarsController extends AbstractController {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> carList=getCarService().getAllCars();
        request.setAttribute("carList",carList);
        RoutingUtils.forwardToPage("cars.jsp", request, response);
    }
}
