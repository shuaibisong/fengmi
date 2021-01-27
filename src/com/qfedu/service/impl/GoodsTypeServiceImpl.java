package com.qfedu.service.impl;

import com.qfedu.dao.impl.GoodsTypeDaoImpl;
import com.qfedu.entity.GoodsType;
import com.qfedu.service.GoodsTypeService;
import com.qfedu.util.BaseDaoNew;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class GoodsTypeServiceImpl implements GoodsTypeService {
    GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();

    @Override
    public List<GoodsType> getAllTypes(int pageNo, int pageSize) {
        List<GoodsType> goodsTypes = goodsTypeDao.selctGoodsType(pageNo, pageSize);
        return goodsTypes;

    }

    @Override
    public int getTypesCount() {
        int countGoodsType = goodsTypeDao.countGoodsType();
        return countGoodsType;
    }

    @Override
    public int deleteType(int id) {
        int goodsTypeId = goodsTypeDao.deleteType(id);
        return goodsTypeId;
    }

    @Override
    public GoodsType getGoodsTypeById(int id) {
        GoodsType goodsTypeById = goodsTypeDao.getGoodsTypeById(id);
        return goodsTypeById;
    }

    @Override
    public int inserct(String typename) {
        int inserct = goodsTypeDao.inserct(typename);
        return inserct;
    }

    @Override
    public int update(String typename,int id) {
        int update = goodsTypeDao.update(typename,id);
        return update;
    }

    @Override
    public boolean in(String typename) {
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        boolean in = goodsTypeDao.in(typename);
        return in;
    }

    @Override
    public List<GoodsType> TypeSelect() {
        List<GoodsType> goodsTypes = goodsTypeDao.TypeSelect();
        return goodsTypes;
    }
}
