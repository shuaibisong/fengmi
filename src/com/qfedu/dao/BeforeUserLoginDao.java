package com.qfedu.dao;

import com.qfedu.entity.User;

import java.util.List;

public interface BeforeUserLoginDao {
    public boolean beforeLogin(String username , String password);
}
