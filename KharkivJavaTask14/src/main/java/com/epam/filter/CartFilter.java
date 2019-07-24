package com.epam.filter;

import com.epam.model.ShoppingCart;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@WebFilter(filterName = "CartFilter")
public class CartFilter implements Filter, Serializable {

    private static final long serialVersionUID = -4691121295725387264L;

    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(CartFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) {
        LOGGER.info("CartFilter was initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        if (shoppingCart == null) {
            session.setAttribute("cart", new ShoppingCart());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
