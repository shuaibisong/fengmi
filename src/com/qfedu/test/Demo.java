package com.qfedu.test;


import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.dao.impl.GoodsTypeDaoImpl;
import com.qfedu.entity.Goods;
import com.qfedu.entity.GoodsType;
import com.qfedu.entity.Order;
import com.qfedu.service.impl.BeforeLoginServiceImpl;
import com.qfedu.service.impl.GoodsServiceImpl;
import com.qfedu.service.impl.GoodsTypeServiceImpl;
import com.qfedu.service.impl.OrderServiceImpl;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        BeforeLoginServiceImpl beforeLoginService = new BeforeLoginServiceImpl();
        boolean root = beforeLoginService.beforeLogin("haha", "123456");
        System.out.println(root);
    }
}
