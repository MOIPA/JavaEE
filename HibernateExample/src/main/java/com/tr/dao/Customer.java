package com.tr.dao;

/**
 * @author tr
 */
public class Customer {
//    create table `cst_customer`(
//            `cust_id` BIGINT(32) NOT NULL AUTO_INCREMENT comment '客户编号',
//            `cust_name` varchar(32) NOT NULL comment '客户名称',
//            `cust_source` varchar(32) DEFAULT NULL comment '客户信息来源',
//            `cust_industry` varchar(32) DEFAULT NULL comment '客户行业',
//            `cust_level` varchar(32) DEFAULT NULL comment '客户级别',
//            `cust_linkman` varchar(64) DEFAULT NULL comment '联系人',
//            `cust_phone` varchar(64) DEFAULT NULL comment '固定电话',
//            `cust_mobile` varchar(16) DEFAULT NULL comment '移动电话',
//    primary key (`cust_id`)
//)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8;
    private long cust_id;
    private String cust_name;
    private String cust_source;
    private String cust_industry;
    private String cust_level;
    private String cust_linkman;
    private String cust_phone;
    private String cust_mobile;

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_source() {
        return cust_source;
    }

    public void setCust_source(String cust_source) {
        this.cust_source = cust_source;
    }

    public String getCust_industry() {
        return cust_industry;
    }

    public void setCust_industry(String cust_industry) {
        this.cust_industry = cust_industry;
    }

    public String getCust_level() {
        return cust_level;
    }

    public void setCust_level(String cust_level) {
        this.cust_level = cust_level;
    }

    public String getCust_linkman() {
        return cust_linkman;
    }

    public void setCust_linkman(String cust_linkman) {
        this.cust_linkman = cust_linkman;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }
}
