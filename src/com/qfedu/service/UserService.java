package com.qfedu.service;

import com.qfedu.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll(int pageNo, int pageSize,String condition);
    public int getCount(String condition);
    public int delet(int id);
    public int update(int id);
    public int insert(String name ,String password, String phone,String mail);
}
