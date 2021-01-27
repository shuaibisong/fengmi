package com.qfedu.controller;

import com.qfedu.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsTypeUpdateServlet")
public class GoodsTypeUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("utf-8");
          response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        String typename = request.getParameter("typename");
        String num = request.getParameter("num");
        String id = request.getParameter("id");
        //System.out.println(num);
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
        boolean b = goodsTypeService.in(typename);
        if(Integer.parseInt(num) == 0){
            if(b){
                int update = goodsTypeService.update(typename, Integer.parseInt(id));
                System.out.println(typename);
                System.out.println(id);
                if (update == 1){
                    response.sendRedirect(contextPath+"/GoodsTypeSelectServlet");
                }
            }else {
                 response.getWriter().append("商品类型重复");
            }

         }else {
            if(b){
                int inserct = goodsTypeService.inserct(typename);
                if(inserct ==1){
                    response.sendRedirect(contextPath+"/GoodsTypeSelectServlet");
                }
            }else {
                response.getWriter().append("商品类型重复");
            }


         }


    }
}
