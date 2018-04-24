package com.tr.dao;

import com.tr.domin.Order;
import com.tr.utils.BaseDataUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl {
    private List<Order> hotOrderList;
    private List<Order> newOrderList;

    public List<Order> getHotOrderList(String com) {
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        String sql = "select count(follower.aid) as followers,ruserorderinfo3.* " +
                "from ruserorderinfo3,orderstatus,follower " +
                "where ruserorderinfo3.com=? and orderstatus!='待审核' " +
                "and ruserorderinfo3.orderid=follower.orderid " +
                "and ruserorderinfo3.orderid=orderstatus.orderid " +
                "group by ruserorderinfo3.orderid order by followers desc limit 9";
        try {
            hotOrderList = queryRunner.query(sql, new BeanListHandler<Order>(Order.class), com);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotOrderList;
    }

    public List<Order> getNewOrderList(String com) {
        String sql = "select count(follower.aid) as followers,ruserorderinfo3.*,orderstatus.* " +
                "from ruserorderinfo3,orderstatus,follower" +
                "where ruserorderinfo3.com=? " +
                "and ruserorderinfo3.orderid=follower.orderid " +
                "and ruserorderinfo3.orderid=orderstatus.orderid " +
                "group by ruserorderinfo3.orderid,orderstatus.orderstatus,orderstatus.peoplelimit,orderstatus.currentpeople";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            newOrderList = queryRunner.query(sql, new BeanListHandler<Order>(Order.class), com);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newOrderList;
    }
}
