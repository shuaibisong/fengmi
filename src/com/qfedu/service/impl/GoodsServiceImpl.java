package com.qfedu.service.impl;

import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.entity.Goods;
import com.qfedu.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDaoImpl goodsDao = new GoodsDaoImpl();
    @Override
    public List<Goods> getAll(int pageNo, int pageSize,String condition) {
        List<Goods> goods = goodsDao.selectAll(pageNo, pageSize,condition);
        return goods;

    }

    @Override
    public int getCount(String condition) {
        int count = goodsDao.count(condition);
        return count;
    }

    @Override
    public int delete(int id) {
        int delete = goodsDao.delete(id);
        return delete;
    }

    @Override
    public Goods getGoodsById(int id) {
        Goods goods = goodsDao.getGoodsById(id);
        return goods;
    }

    @Override
    public int insert(String goodsName, double price, String imgPath, String comment,int typeId) {
        int insert = goodsDao.insert(goodsName, price, imgPath, comment,typeId);
        return insert;
    }

    @Override
    public int update(String goodsName, double price, String imgPath, String comment, int typeId, int id) {
        int update = goodsDao.update(goodsName, price, imgPath, comment, typeId, id);
        return update;
    }
}
