package com.tr.domin;

import java.util.Date;

public class Order {

//    {"followers":"2","orderid":"140",
// "account":"","ordertheme":"","ordercontent":"","ordertime":"","promulgatorid":"97"
// ,"com":"","posttime":"2018-04-12 00:47:34","name":null,"age":null,"sex":null,
// "uiconsrc":"1\u680b\u738b\u963f\u59e8-IMG_0167.JPG","rorderpicsrc":"-IMG_0170.JPG"}
    private int price;
    private int followers;
    private int orderid;
    private int promulgatorid;
    private String account;
    private String ordertheme;
    private String ordercontent;
    private String ordertime;
    private String com;
    private String posttime;
    private String name;
    private String age;
    private String sex;
    private String uiconsrc;
    private String rorderpicsrc;

    private String peoplelimit;
    private String currentpeople;
    private String orderstatus;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPeoplelimit() {
        return peoplelimit;
    }

    public void setPeoplelimit(String peoplelimit) {
        this.peoplelimit = peoplelimit;
    }

    public String getCurrentpeople() {
        return currentpeople;
    }

    public void setCurrentpeople(String currentpeople) {
        this.currentpeople = currentpeople;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getPromulgatorid() {
        return promulgatorid;
    }

    public void setPromulgatorid(int promulgatorid) {
        this.promulgatorid = promulgatorid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOrdertheme() {
        return ordertheme;
    }

    public void setOrdertheme(String ordertheme) {
        this.ordertheme = ordertheme;
    }

    public String getOrdercontent() {
        return ordercontent;
    }

    public void setOrdercontent(String ordercontent) {
        this.ordercontent = ordercontent;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUiconsrc() {
        return uiconsrc;
    }

    public void setUiconsrc(String uiconsrc) {
        this.uiconsrc = uiconsrc;
    }

    public String getRorderpicsrc() {
        return rorderpicsrc;
    }

    public void setRorderpicsrc(String rorderpicsrc) {
        this.rorderpicsrc = rorderpicsrc;
    }
}
