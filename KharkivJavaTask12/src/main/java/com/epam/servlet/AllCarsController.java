package com.epam.servlet;

import com.epam.entity.Car;
import com.epam.model.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class AllCarsController extends AbstractController {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offset = getOffset(request);
        int limitPerPage = getNumberOfDisplayedCars(request);
        int count=getCarService().countAllCars();

        List<Car> carList = getCarService().getAllCars(offset, limitPerPage);
        request.setAttribute("carList", carList);

        Pagination pagination = new Pagination.Builder(request.getRequestURI() + "?", offset, count).withLimit(limitPerPage).build();
        request.setAttribute("pagination", pagination);

        forwardToPage("cars.jsp", request, response);
    }
}
