package com.tr.service;

import com.tr.domin.Order;
import com.tr.domin.PostOrderInfo;
import org.apache.commons.fileupload.FileItem;

import java.util.List;

public interface OrderService {

    public void uploadActivityInfo(PostOrderInfo postOrderInfo);

    public String savePic(String savePath, List<FileItem> list);

    public List<Order> getNewOrderList(String com);

    public List<Order> getHotOrderList(String com);

    public void uploadOrderInfo(PostOrderInfo postOrderInfo);
}
