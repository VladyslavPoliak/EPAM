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

    private static final long serialVersionUID = 5938254532040802476L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offset = getOffset(request);

        List<Car> carList = getCarService().getAllCars(offset, getCountPerPage(request));
        int countAllCars = getCarService().countAllCars();
        request.setAttribute("carList", carList);

        Pagination pagination = new Pagination.Builder(request.getRequestURI() + "?", offset, countAllCars).withLimit(DEFAULT_CAR_PER_PAGE).build();
        request.setAttribute("pagination", pagination);

        forwardToPage("cars.jsp", request, response);
    }
}
