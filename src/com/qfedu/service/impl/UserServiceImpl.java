package com.qfedu.service.impl;

import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAll(int pageNo, int pageSize,String condition) {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.selectAll(pageNo, pageSize,condition);
        return users;

    }

    @Override
    public int getCount(String condition) {
        UserDaoImpl userDao = new UserDaoImpl();
        int count = userDao.count(condition);
        return count;
    }

    @Override
    public int delet(int id) {
        UserDaoImpl userDao = new UserDaoImpl();
        int delet = userDao.delet(id);
        return delet;
    }

    @Override
    public int update(int id) {
        UserDaoImpl userDao = new UserDaoImpl();
        int update = userDao.update(id);
        return update;
    }

    @Override
    public int insert(String name, String password, String phone,String mail) {
        UserDaoImpl userDao = new UserDaoImpl();
        int inserct = userDao.inserct(name, password, phone,mail);
        return inserct;
    }
}
