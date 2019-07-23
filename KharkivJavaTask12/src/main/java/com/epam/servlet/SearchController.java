package com.epam.servlet;

import com.epam.entity.Car;
import com.epam.form.SearchForm;
import com.epam.model.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchController extends AbstractController {

    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        SearchForm searchForm = createSearchForm(req);

        int offset = getOffset(req);

        List<Car> carList = getCarService().listCarsBySearchForm(searchForm, getCountPerPage(req), offset);
        req.setAttribute("carList", carList);

        int countBySearch = getCarService().countCarsBySearchForm(searchForm);

        System.out.println(countBySearch);
        System.out.println(carList.size());

        Pagination pagination = new Pagination.Builder(req.getRequestURI()+"?"+req.getQueryString() , offset, countBySearch).build();
        req.setAttribute("pagination", pagination);

        req.setAttribute("carCount", countBySearch);

        req.setAttribute("searchForm", searchForm);

        forwardToPage("search-result.jsp", req, response);
    }
}
