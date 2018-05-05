package com.tr.dao;

import com.tr.domin.Order;
import com.tr.domin.PostOrderInfo;
import org.apache.commons.fileupload.FileItem;

import java.util.List;

public interface OrderDao {

    public boolean uploadActivityInfo(PostOrderInfo postOrderInfo);

    public List<String> savePic(String savePath, List<FileItem> list);

    public List<Order> getNewOrderList(String com);

    public List<Order> getHotOrderList(String com);

    public boolean uploadOrderInfo(PostOrderInfo postOrderInfo);

    public Order getDetailInfoById(String orderid);
}
