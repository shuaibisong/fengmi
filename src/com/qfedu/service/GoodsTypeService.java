package com.qfedu.service;

import com.qfedu.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    public List<GoodsType> getAllTypes(int pageNo,int pageSize );
    public int getTypesCount();
    public int deleteType(int id);
    public GoodsType getGoodsTypeById(int id);
    public int inserct(String typename);
    public int update(String typename,int id);
    public boolean in(String typename);
    public List<GoodsType> TypeSelect();
}
