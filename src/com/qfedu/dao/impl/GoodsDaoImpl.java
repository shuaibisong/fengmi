package com.qfedu.dao.impl;

import com.qfedu.dao.GoodsDao;
import com.qfedu.entity.Goods;
import com.qfedu.util.BaseDaoNew;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    List<Goods> select =null;
    @Override
    public List<Goods> selectAll(int pageNo , int pageSize,String condition) {
        String sql=" select g.id,g.goodsName,g.price,g.score,g.deployDate,g.comment,g.imgPath,t.typename,g.typeId from t_goods g  inner join t_goodstype t  on t.id = g.typeId where 1=1 "+condition+" limit ?,?";
        Object[] objects={(pageNo-1)*pageSize,pageSize};
        try {
             select = BaseDaoNew.select(sql, objects, Goods.class);
            return select;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
          return null;

    }

    @Override
    public int count(String condition) {
        String sql="select * from t_goods where 1=1 "+condition;
        try {
            List<Goods> select1 = BaseDaoNew.select(sql, null, Goods.class);
            return select1.size();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        String sql ="delete from t_goods where id = ?";
        Object[] objects={id};
        try {
            int update = BaseDaoNew.update(sql, objects);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return 0;
    }

    @Override
    public Goods getGoodsById(int id) {
        String sql="SELECT t_goods.id,goodsName ,price,score,deployDate,imgPath,COMMENT,typeId,t_goodstype.typename from t_goods,t_goodstype where t_goods.typeid=t_goodstype.id and  t_goods.id = ?";
        Object[] objects ={id};
        try {
            List<Goods> select = BaseDaoNew.select(sql, objects, Goods.class);
            for (Goods goods : select) {
                return goods;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(String goodsName, double price, String imgPath, String comment,int typeId) {
        String sql="insert into t_goods(goodsName,price,imgPath,comment,typeId) values(?,?,?,?,?)";
        Object[] objects={goodsName,price,imgPath,comment,typeId};
        try {
            int update = BaseDaoNew.update(sql, objects);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(String goodsName, double price, String imgPath, String comment, int typeId,int id) {
        String sql ="update t_goods set goodsName=? ,price=? ,imgPath=?,comment=?,typeId=? where id = ?";
        Object[] objects = {goodsName, price, imgPath, comment, typeId, id};
        try {
            int update = BaseDaoNew.update(sql, objects);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
