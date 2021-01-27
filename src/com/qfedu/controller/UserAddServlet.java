package com.qfedu.controller;

import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String contextPath = request.getContextPath();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        UserServiceImpl userService = new UserServiceImpl();
        int insert = userService.insert(username, password, phone, mail);
        if(insert==1){
            response.sendRedirect(contextPath+"/UserFuzzyServlet");
        }


    }
}
