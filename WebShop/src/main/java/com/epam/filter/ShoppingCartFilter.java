package com.epam.filter;

import com.epam.constans.Constants;
import com.epam.model.ShoppingCart;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@WebFilter(filterName = "ShoppingCartFilter")
public class ShoppingCartFilter implements Filter, Serializable {

    private static final long serialVersionUID = -4691121295725387264L;

    private static final Logger LOGGER = Logger.getLogger(ShoppingCartFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) {
        LOGGER.info("ShoppingCartFilter was initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute(Constants.CURRENT_SHOPPING_CART);
        if (shoppingCart == null) {
            session.setAttribute(Constants.CURRENT_SHOPPING_CART, new ShoppingCart());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
