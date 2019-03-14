package com.tr.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity  //声明实体类用于之后和表关联
@Table(name = "cst_customer")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成策略 自增
    @Column(name = "cust_id") //和表字段映射
    private Integer cust_id;
    private String cust_name;
    private String cust_source;
    private String industry;
    private String cust_level;
    private String cust_linkman;
    private String cust_phone;
    private String cust_mobile;

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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

    @Override
    public String toString() {
        return this.getCust_name()+"|"+this.getCust_id();
    }
}
