package com.qfedu.dao;

import com.qfedu.entity.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    public List<GoodsType> selctGoodsType(int pageNo ,int pageSize);
    public int countGoodsType();
    public int deleteType(int id);
    public GoodsType getGoodsTypeById(int id);
    public int inserct(String typename);
    public int update(String typename,int id);
    public boolean in(String typename);
    public List<GoodsType> TypeSelect();

}
