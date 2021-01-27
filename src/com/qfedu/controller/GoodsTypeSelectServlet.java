package com.qfedu.controller;

import com.qfedu.entity.GoodsType;
import com.qfedu.service.impl.GoodsTypeServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GoodsTypeSelectServlet")
public class GoodsTypeSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");
        String pgNo = request.getParameter("pageNo");
        PageUtil pageUtil = new PageUtil();
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
        if(pgNo == null){
            pgNo ="1";
        }
        int pageNo = Integer.parseInt(pgNo);
        int pageSize = 3;
        int dateCount = goodsTypeService.getTypesCount();
        pageUtil.setPageNo(pageNo);
        pageUtil.setDataCount(dateCount);
        pageUtil.setPageSize(pageSize);
        int pageCount = pageUtil.getPageCount();
        List<GoodsType> types = goodsTypeService.getAllTypes(pageNo, pageSize);
        request.setAttribute("list",types);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/goods_type_list.jsp").forward(request,response);

    }
}
