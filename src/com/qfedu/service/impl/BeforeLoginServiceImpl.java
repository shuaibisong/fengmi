package com.qfedu.service.impl;

import com.qfedu.dao.impl.BeforeUserLoginDaoImpl;
import com.qfedu.service.BeforeLoginService;

public class BeforeLoginServiceImpl implements BeforeLoginService {
    @Override
    public boolean beforeLogin(String username, String password) {
        BeforeUserLoginDaoImpl beforeUserLoginDao = new BeforeUserLoginDaoImpl();
        boolean b = beforeUserLoginDao.beforeLogin(username, password);
        return b;
    }
}
