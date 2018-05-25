package com.tr.service;

import com.tr.domin.*;
import org.apache.commons.fileupload.FileItem;

import java.util.List;

public interface OrderService {

    public void uploadActivityInfo(PostOrderInfo postOrderInfo);

    public String savePic(String savePath, List<FileItem> list);

    public List<Order> getNewOrderList(String com);

    public List<Order> getHotOrderList(String com);

    public int uploadOrderInfo(PostOrderInfo postOrderInfo);

    public Order getDetailInfoById(String orderid);

    public List<String> getPicUrls(String orderid);

    public List<Follower> getFollower(String orderid);

    public boolean saveUserAvatar(String savePath, List<FileItem> list, String aid);

    public int followBehaviour(String remark, String aid, String orderid, String byerPayUrl);

    public List<Order> getUnPassedOrderListByCname(String cname);

    public List<Order> getPassedOrderListByCname(String cname);

    public boolean passBehaviour(String orderid);

    public List<Order> getMyFollowedOrder(String aid);

    public List<Order> getMyPostedOrder(String aid);

    public boolean saveUserPayCode(String savePath, List<FileItem> list, String account);

    public String getPayCode(String orderId);

    public String saveByerPayUrl(String savePath, List<FileItem> list, String orderId);

    public List<UserPay> getPayedOrder(String orderid);

    public boolean setOrderStatusToPayed(String orderid);

    public boolean sendGoods(String orderid);

    public boolean receiveGoods(String orderid);

    public List<SoldGoods> getMySoldOrder(String aid);
}
