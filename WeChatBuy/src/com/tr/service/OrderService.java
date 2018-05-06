package com.tr.service;

import com.tr.domin.Follower;
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

    public Order getDetailInfoById(String orderid);

    public List<String> getPicUrls(String orderid);

    public List<Follower> getFollower(String orderid);

    public boolean saveUserAvatar(String savePath, List<FileItem> list, String aid);

    public String followBehaviour(String remark, String aid, String orderid);
}
