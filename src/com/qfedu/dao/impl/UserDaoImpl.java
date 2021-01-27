package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.util.BaseDaoNew;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> selectAll(int pageNo, int pageSize,String condition) {
        String sql="select * from t_user where 1=1 " + condition + " limit ? ,?";
        Object[] objects={(pageNo-1)*pageSize ,pageSize};
        try {
            List<User> select = BaseDaoNew.select(sql, objects, User.class);
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
        String sql="select * from t_user where 1=1 "+condition;
        try {
            List<User> select = BaseDaoNew.select(sql, null, User.class);
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
    public int delet(int id) {
        String sql = "delete  from t_user  where id = ?";
        Object[] objects = {id};
        try {
            int update = BaseDaoNew.update(sql, objects);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return 0;
    }

    @Override
    public int update(int id) {
        String sql = "update t_user set password = ? where id =?";
        Object[] objects ={123456,id};
        try {
            int update = BaseDaoNew.update(sql, objects);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int inserct(String name, String password, String phone,String mail) {
        String sql ="insert into t_user(username,password,phone,mail) values(?,?,?,?)";
        Object[] objects={name,password,phone,mail};
        try {
            int update = BaseDaoNew.update(sql, objects);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return 0;
    }
}
