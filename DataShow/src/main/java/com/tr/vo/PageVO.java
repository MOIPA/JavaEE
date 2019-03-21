package com.tr.vo;

import java.util.List;

/**
 * @author tr
 * @param <T>
 */
public class PageVO<T> {
    private int total;
    private List<T> data;

    public PageVO(int total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public PageVO() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
