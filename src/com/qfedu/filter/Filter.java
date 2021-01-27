package com.qfedu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) req).getSession();
        Object username = session.getAttribute("username");
        String requestURI = ((HttpServletRequest) req).getRequestURI();
        if (requestURI.endsWith("/login.jsp") || requestURI.endsWith("/LoginServlet")) {
            chain.doFilter(req, resp);
        } else if (session == null || session.getAttribute("username") == null) {
            ((HttpServletResponse)resp).sendRedirect(((HttpServletRequest) req).getContextPath()+"/after/login.jsp");
        } else if (session != null && session.getAttribute("username") != null) {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
