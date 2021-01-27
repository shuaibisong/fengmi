package com.qfedu.dao.impl;

import com.qfedu.dao.AdimDao;
import com.qfedu.entity.Admin;
import com.qfedu.util.BaseDaoNew;

import java.util.List;

public class AdminDaoImpl  implements AdimDao {
    @Override
    public boolean login(String username, String password) {
        String spl = "select * from admin where username = ? and password = ?";
        Object[] objects = {username, password};
        try {
            List<Admin> select = BaseDaoNew.select(spl, objects, Admin.class);
            if (select.size()==1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

           return  false;
    }
}
