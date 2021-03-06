package com.qfedu.controller;

import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserResetServlet")
public class UserResetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
        String contextPath = request.getContextPath();
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        UserServiceImpl userService = new UserServiceImpl();
        int update = userService.update(i);
        if(update==1){
            response.sendRedirect(contextPath+"/UserFuzzyServlet");
        }
    }
}

