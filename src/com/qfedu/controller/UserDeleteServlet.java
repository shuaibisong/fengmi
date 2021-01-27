package com.qfedu.controller;

import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String contextPath = request.getContextPath();
        String id = request.getParameter("id");
        UserServiceImpl userService = new UserServiceImpl();
        int userId = Integer.parseInt(id);
        int delet = userService.delet(userId);
        if(delet == 1){
            response.sendRedirect(contextPath+"/UserFuzzyServlet");
        }else {
            response.getWriter().append("删除失败");
        }
    }
}

