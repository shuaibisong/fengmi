package com.qfedu.service.impl;

import com.qfedu.dao.impl.OrderDaoImpl;
import com.qfedu.entity.Order;
import com.qfedu.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {


    @Override
    public List<Order> selectAll(int pageNo, int pageSize,String condition) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        List<Order> orders = orderDao.selectAll(pageNo, pageSize,condition);
        return orders;
    }

    @Override
    public int count(String condition) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int count = orderDao.count(condition);
        return count;
    }

    @Override
    public int delete(int ordersid) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int d = orderDao.delete(ordersid);
        return d;
    }
}
