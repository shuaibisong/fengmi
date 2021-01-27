package com.qfedu.service.impl;

import com.qfedu.dao.impl.AdminDaoImpl;
import com.qfedu.service.AdminService;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean getLogin(String username, String password) {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        boolean login = adminDao.login(username, password);
        return login;
    }
}
