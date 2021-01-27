package com.qfedu.dao;

import com.qfedu.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> selectAll(int pageNo, int pageSize ,String condition);
    public int count(String condition);
    public int delet(int id);
    public int update(int id);
    public int inserct(String name ,String password, String phone,String mail);


}
