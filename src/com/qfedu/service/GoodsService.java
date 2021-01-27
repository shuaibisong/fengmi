package com.qfedu.service;

import com.qfedu.entity.Goods;

import java.util.List;

public interface GoodsService {
    public List<Goods> getAll(int pageNo , int pageSize,String condition);
    public int getCount(String conditon);
    public int delete(int id);
    public Goods getGoodsById(int id);
    public int insert(String goodsName, double price ,String imgPath ,String comment,int typeId);
    public int update(String goodsName, double price ,String imgPath ,String comment,int typeId,int id);
}
