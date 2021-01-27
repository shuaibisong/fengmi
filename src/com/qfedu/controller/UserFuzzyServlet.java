package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.impl.UserServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserFuzzyServlet")
public class UserFuzzyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserServiceImpl userService = new UserServiceImpl();
        StringBuffer condition = new StringBuffer();
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        if(username!=null && !"".equals(username) && sex!=null && !"".equals(sex)){
            condition.append("and username like '%"+username+"%'"+"and sex =\""+sex+ "\"");
        }else if(username!=null && !"".equals(username)){
            condition.append("and username like '%"+username+"%'");
        }else if(sex!=null && !"".equals(sex)){
            condition.append("and sex =\""+sex+ "\"");
        }
        int dateCount = userService.getCount(condition.toString());
        
        int pageSize = 3;
        String pNo = request.getParameter("pageNo");
        if(pNo == null){
            pNo="1";
        }
        int pageNo = Integer.parseInt(pNo);
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNo(pageNo);
        List<User> all = userService.getAll(pageNo, pageSize,condition.toString());
        pageUtil.setDataCount(dateCount);
        int pageCount = pageUtil.getPageCount();
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("list",all);
        request.setAttribute("sex",sex);
        request.setAttribute("username",username);
        request.getRequestDispatcher("/after/user.jsp").forward(request,response);


    }
}
