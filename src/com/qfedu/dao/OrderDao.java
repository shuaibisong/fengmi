package com.qfedu.dao;

import com.qfedu.entity.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> selectAll(int pageNo,int pageSize,String condition);
    public int count(String condition);
    public int delete(int ordersid);
}
