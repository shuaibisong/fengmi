package com.qfedu.controller;

import com.qfedu.entity.Order;
import com.qfedu.service.impl.OrderServiceImpl;
import com.qfedu.util.DateUtil;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/OrderFuzzySelectServlet")
public class OrderFuzzySelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
        StringBuffer buffer = new StringBuffer();
        String username = request.getParameter("username");
        System.out.println(username);

        if (username != null && !"".equals(username)) {
            //当模糊查询的时候，把这个下面这个字符串拼接到sql语句中
            buffer.append("and username like '%"+username+"%'");
        }
        String pNo = request.getParameter("pageNo");
        if (pNo == null) {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 3;
        PageUtil pageUtil = new PageUtil();
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<Order> orders = orderService.selectAll(pageNo, pageSize,buffer.toString());
        int dateCount = orderService.count(buffer.toString());
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dateCount);
        int pageCount = pageUtil.getPageCount();
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("list",orders);
        request.getRequestDispatcher("/after/order_processing_list.jsp").forward(request,response);


    }
}
