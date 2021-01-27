package com.qfedu.dao;

import com.qfedu.entity.Goods;

import java.util.List;

public interface GoodsDao {
    public List<Goods> selectAll(int pageNo , int pageSize, String condition);
    public int count(String condition);
    public int delete(int id);
    public Goods getGoodsById(int id);
    public int insert(String goodsName, double price ,String imgPath ,String comment,int typeId);
    public int update(String goodsName, double price ,String imgPath ,String comment,int typeId,int id);
}
