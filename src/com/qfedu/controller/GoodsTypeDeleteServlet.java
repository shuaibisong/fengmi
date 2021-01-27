package com.qfedu.controller;

import com.qfedu.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsTypeDeleteServlet")
public class GoodsTypeDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String i = request.getParameter("id");
        int goodsTypeId = Integer.parseInt(i);
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
        int j = goodsTypeService.deleteType(goodsTypeId);
        if(j==1){
            response.sendRedirect(contextPath+"/GoodsTypeSelectServlet");
        }else {
            response.getWriter().append("删除失败");
        }
    }
}

