package com.qfedu.controller;

import com.qfedu.service.impl.OrderServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        OrderServiceImpl orderService = new OrderServiceImpl();
        String ordersid = request.getParameter("ordersid");
        int id = Integer.parseInt(ordersid);
        int delete = orderService.delete(id);

        if(delete==1){
            response.sendRedirect(contextPath+"/OrderFuzzySelectServlet");
        }else {
            response.getWriter().append("删除失败");
        }
    }
}
