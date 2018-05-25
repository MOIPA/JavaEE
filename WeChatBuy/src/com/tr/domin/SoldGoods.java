package com.tr.domin;

public class SoldGoods {
    private String orderid;
    private String dealTime;
    private String ordertheme;
    private String posttime;
    private String price;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getOrdertheme() {
        return ordertheme;
    }

    public void setOrdertheme(String ordertheme) {
        this.ordertheme = ordertheme;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }
}
