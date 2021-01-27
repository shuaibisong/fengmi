package com.qfedu.controller;

import com.qfedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DeletGoodsServlet")
public class DeletGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset+utf-8");
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        String i = request.getParameter("goodsid");
        int delete = 0;
        String[] ids = i.split(",,");
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        for (int j = 0; j < ids.length; j++) {
            System.out.println(ids[j]);
        }
        for (int j = 0; j < ids.length; j++) {
            if (!ids[j].equals("")) {
                int goodsid = Integer.parseInt(ids[j]);
                delete = goodsService.delete(goodsid);
            }
        }

        if (delete == 1) {
            response.sendRedirect(contextPath + "/FuzzySelectGoods");
        } else {
            response.getWriter().append("删除失败");
        }
    }
}