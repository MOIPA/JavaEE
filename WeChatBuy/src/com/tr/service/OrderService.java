package com.tr.service;

import com.tr.dao.OrderDao;
import com.tr.domin.Order;

import java.util.List;

public class OrderService {

    private List<Order> hotOrderList;
    private List<Order> newOrderList;

    //获得热门订单
    public List<Order> getHotOrderList(String com) {
        OrderDao dao = new OrderDao();
        return dao.getHotOrderList(com);
    }

    //获得最新订单
    public List<Order> getNewOrderList(String com) {
        OrderDao dao = new OrderDao();
        return dao.getNewOrderList(com);
    }
}
