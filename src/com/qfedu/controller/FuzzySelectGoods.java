package com.qfedu.controller;

import com.qfedu.entity.Goods;
import com.qfedu.entity.GoodsType;
import com.qfedu.service.GoodsService;
import com.qfedu.service.impl.GoodsServiceImpl;
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

@WebServlet("/FuzzySelectGoods")
public class FuzzySelectGoods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pgNo = request.getParameter("pageNo");
        if(pgNo==null){
            pgNo="1";
        }
        int pageNo = Integer.parseInt(pgNo);
        PageUtil pageUtil = new PageUtil();
        int pageSize = 5;
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        int dateCount = goodsService.getCount();
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNo(pageNo);
        pageUtil.setDataCount(dateCount);
        int pageCount = pageUtil.getPageCount();
        List<Goods> all = goodsService.getAll(pageNo, pageSize);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("dateCount",dateCount);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("list", all);
        request.getRequestDispatcher("/after/goods_list.jsp").forward(request,response);*/
        request.setCharacterEncoding("utf-8");
        StringBuffer condition = new StringBuffer();
        PageUtil pu = new PageUtil();
        GoodsService gs=new GoodsServiceImpl();
        GoodsType gp=new GoodsType();
        Goods gd=new Goods();
        String goodsname=request.getParameter("goodsname");
        if (goodsname != null && !"".equals(goodsname)) {
            //当模糊查询的时候，把这个下面这个字符串拼接到sql语句中
            condition.append("and goodsname like '%"+goodsname +"%'");
        }
        String deployDate1=request.getParameter("deployDate");
        if(deployDate1!=null && !"".equals(deployDate1)) {
            Date deployDate=(Date) DateUtil.convert(deployDate1);
            condition.append(" and deployDate like '%"+deployDate+"%'");
        }
        String typeId=request.getParameter("typeId");
        if(typeId!=null && !"".equals(typeId)) {
            int typeid=Integer.parseInt(typeId);
            condition.append(" and typeid = "+typeid);
        }
        int dataCount = 0;
        try {
            dataCount = gs.getCount(condition.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String pNo = request.getParameter("pageNo");
        if (pNo == null) {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 3;
        pu.setPageNo(pageNo);
        pu.setDataCount(dataCount);
        pu.setPageSize(pageSize);
        int pageCount = pu.getPageCount();
        System.out.println(pageCount);
        List<Goods> list = null;
        try {
            list = gs.getAll(pageNo, pageSize, condition.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("goodsname",goodsname);
        request.setAttribute("list", list);
        request.setAttribute("typeId", typeId);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("dateCount",dataCount);
        request.setAttribute("pageCount", pageCount);
        request.getRequestDispatcher("/after/goods_list.jsp").forward(request, response);
    }

    }

