package com.epam.servlet;

import com.epam.entity.Car;
import com.epam.utils.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/classes/*")
public class CarsByClassController extends AbstractController {

    private final int SUBSTRING_INDEX = "/classes/".length();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classUrl = req.getRequestURI().substring(SUBSTRING_INDEX);
        List<Car> carList = getCarService().listCarsByClass(classUrl);
        req.setAttribute("carList", carList);

        RoutingUtils.forwardToPage("cars.jsp", req, resp);
    }
}
