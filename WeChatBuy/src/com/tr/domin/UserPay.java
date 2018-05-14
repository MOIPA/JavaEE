package com.tr.domin;

public class UserPay {
    private String aid;
    private String uiconsrc;
    private String account;
    private String email;
    private String picurl;
    private String ordertheme;
    private String orderid;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUiconsrc() {
        return uiconsrc;
    }

    public void setUiconsrc(String uiconsrc) {
        this.uiconsrc = uiconsrc;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getOrdertheme() {
        return ordertheme;
    }

    public void setOrdertheme(String ordertheme) {
        this.ordertheme = ordertheme;
    }
}
