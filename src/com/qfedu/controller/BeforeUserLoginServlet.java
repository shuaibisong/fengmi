package com.qfedu.controller;

import com.qfedu.service.impl.BeforeLoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/BeforeUserLoginServlet")
public class BeforeUserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        BeforeLoginServiceImpl beforeLoginService = new BeforeLoginServiceImpl();
        boolean b = beforeLoginService.beforeLogin(username, password);
        if (b){
            HttpSession session = request.getSession();
            session.setAttribute("name","login");
            response.sendRedirect(contextPath+"/before/index.html");
        }else {
            response.sendRedirect(contextPath+"/before/login.html");
        }

    }
}
