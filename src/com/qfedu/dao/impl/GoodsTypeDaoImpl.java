package com.qfedu.dao.impl;

import com.qfedu.dao.GoodsTypeDao;
import com.qfedu.entity.GoodsType;
import com.qfedu.util.BaseDaoNew;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class GoodsTypeDaoImpl implements GoodsTypeDao {
    @Override
    public List<GoodsType> selctGoodsType(int pageNo, int pageSize) {
        String sql = "select * from t_goodstype limit ?,?";
        Object[] objects = {(pageNo - 1) * pageSize, pageSize};
        try {
            List<GoodsType> select = BaseDaoNew.select(sql, objects, GoodsType.class);
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
    public int countGoodsType() {
        String sql = "select * from t_goodstype";
        try {
            List<GoodsType> select = BaseDaoNew.select(sql, null, GoodsType.class);
            return select.size();
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
    public int deleteType(int id) {
        String sql = "delete from t_goodstype where id =?";
        Object[] objects = {id};
        try {
            int update = BaseDaoNew.update(sql, objects);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public GoodsType getGoodsTypeById(int id) {
        String sql = "select * from t_goodstype where id =?";
        Object[] objects = {id};
        try {
            List<GoodsType> select = BaseDaoNew.select(sql, objects, GoodsType.class);
            for (GoodsType goodsType : select) {
                return goodsType;
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
    public int inserct(String typename) {
        String sql = "insert into t_goodstype(typename) values(?) ";
        Object[] objects = {typename};
        try {
            int update = BaseDaoNew.update(sql, objects);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(String typename, int id) {
        String sql = "update t_goodstype set typename = ? where id =?";
        Object[] objects = {typename, id};
        try {
            int update = BaseDaoNew.update(sql, objects);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public boolean in(String typename) {
        String sql="select * from t_goodstype where typename = ?";
        Object[] objects={typename};
        try {
            List<GoodsType> select = BaseDaoNew.select(sql, objects, GoodsType.class);
            if(select.size()==0){
                return true;
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
        return false;
    }

    @Override
    public List<GoodsType> TypeSelect() {
        String sql="select * from t_goodstype";
        try {
            List<GoodsType>  select = BaseDaoNew.select(sql, null, GoodsType.class);
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
}



