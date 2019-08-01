package com.epam.parser;

import com.epam.constans.Constants;
import com.epam.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

public class SecurityFilter implements Filter {

    public static final Logger LOGGER = Logger.getLogger(SecurityFilter.class.getName());
    private PermissionEvaluator permissionEvaluator;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        LOGGER.info("initialize security filter");
        this.permissionEvaluator = (PermissionEvaluator) servletContext.getAttribute("permissionEvaluator");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String url = req.getServletPath();
        if (permissionEvaluator.isPathSecured(url)) {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute(Constants.CURRENT_ACCOUNT);
            if (user == null) {
                session.setAttribute("redirect", req.getRequestURI());
                resp.sendRedirect(req.getContextPath() + Constants.MAIN_PAGE);
            } else {
                if (permissionEvaluator.hasAccess(user.getRole(), url)) {
                    filterChain.doFilter(servletRequest, servletResponse);

                } else {
                    resp.sendError(HttpServletResponse.SC_FORBIDDEN, "error.forbidden");
                }
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
