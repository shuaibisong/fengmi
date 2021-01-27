package com.qfedu.dao.impl;

import com.qfedu.dao.BeforeUserLoginDao;
import com.qfedu.entity.User;
import com.qfedu.util.BaseDaoNew;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class BeforeUserLoginDaoImpl implements BeforeUserLoginDao {
    @Override
    public boolean beforeLogin(String username, String password) {
        String sql="select * from t_user where username = ? and password = ?";
        Object[] objects={username,password};
        try {
            List<User> select = BaseDaoNew.select(sql, objects, User.class);
            if (select.size()==1){
                return true;
            }
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
        return false;
    }
}
