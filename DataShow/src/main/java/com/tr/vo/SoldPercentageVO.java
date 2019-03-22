package com.tr.vo;


public class SoldPercentageVO {
    private String sale;
    private String percentage;

    public SoldPercentageVO(String sale, String percentage) {
        this.sale = sale;
        this.percentage = percentage;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
