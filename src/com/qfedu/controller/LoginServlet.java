package com.qfedu.controller;


import com.qfedu.service.AdminService;
import com.qfedu.service.impl.AdminServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminService adminService = new AdminServiceImpl();
        boolean login = adminService.getLogin(username,password);
        if (login) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect(servletContext.getContextPath()+"/UserFuzzyServlet");
        }else {
            response.sendRedirect(servletContext.getContextPath()+"/after/login.jsp");
        }

    }
    }

