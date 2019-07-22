package com.epam.servlet;

import com.epam.entity.Car;
import com.epam.form.SearchForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchController extends AbstractController {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SearchForm searchForm = createSearchForm(request);

        List<Car> carList = getCarService().listCarsBySearchForm(searchForm);
        request.setAttribute("carList", carList);
        request.setAttribute("carCount", carList.size());
        request.setAttribute("searchForm", searchForm);

        forwardToPage("search-result.jsp", request, response);
    }
}
