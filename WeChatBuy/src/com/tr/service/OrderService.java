package com.tr.service;

import com.tr.dao.OrderDaoImpl;
import com.tr.domin.Order;

import java.util.List;

public class OrderService {

    private List<Order> hotOrderList;
    private List<Order> newOrderList;

    //获得热门订单
    public List<Order> getHotOrderList(String com) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getHotOrderList(com);
    }

    //获得最新订单
    public List<Order> getNewOrderList(String com) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getNewOrderList(com);
    }
}
