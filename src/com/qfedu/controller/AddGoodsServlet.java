package com.qfedu.controller;

import com.qfedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddGoodsServlet")
@MultipartConfig
public class AddGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        String goodsName = request.getParameter("goodsName");
        String parameter = request.getParameter("price");
        String typeId = request.getParameter("typeId");
        System.out.println(typeId);
        int typeid = Integer.parseInt(typeId);
        System.out.println(parameter);
        double price = Double.parseDouble(parameter);
        System.out.println(goodsName);
        System.out.println(parameter);
        String imgPath = request.getParameter("imgPath");
        String description = request.getParameter("comment");
        String no = request.getParameter("num");
        int num = Integer.parseInt(no);
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        int number = 0;
        if (num == 1) {
            String id1 = request.getParameter("id");
            int id = Integer.parseInt(id1);
            number = goodsService.update(goodsName, price, imgPath, description, typeid, id);
        } else {
            number = goodsService.insert(goodsName, price, imgPath, description, typeid);


        }
        if (number == 1) {
            response.sendRedirect(contextPath + "/FuzzySelectGoods");
        } else {
            response.getWriter().append("添加失败");
        }
    }
}
