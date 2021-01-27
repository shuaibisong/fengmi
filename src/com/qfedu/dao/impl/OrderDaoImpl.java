package com.qfedu.dao.impl;

import com.qfedu.dao.OrderDao;
import com.qfedu.entity.Order;
import com.qfedu.util.BaseDaoNew;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public List<Order> selectAll(int pageNo, int pageSize,String condition) {
        String sql=" select * from t_order inner join t_status on t_order.status = t_status.id inner join t_user on t_order.uid=t_user.id where 1=1 "+condition+" limit ?,?";
        Object[] objects={(pageNo-1)*pageSize,pageSize};
        try {
            List<Order> select = BaseDaoNew.select(sql, objects, Order.class);
            return select;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int count(String condition) {
        String sql=" select * from t_order inner join t_status on t_order.status = t_status.id inner join t_user on t_order.uid=t_user.id where 1=1 "+condition;
        try {
            List<Order> select = BaseDaoNew.select(sql, null, Order.class);
            return select.size();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
         return 0;
    }

    @Override
    public int delete(int ordersid) {
        String sql="delete from t_order where id = ?";
        Object[] objects={ordersid};
        try {
            int update = BaseDaoNew.update(sql, objects);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
