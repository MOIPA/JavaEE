package com.tr.dao;

import com.tr.domin.Follower;
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

    public List<Object> getPicUrls(String orderid);

    public List<Follower> getFollowerList(String orderid);

    public int getUserAddressId(String aid);

    public int followBehaviour(String remark, String aid, String orderid, int addressId);

    public boolean checkIsFollowed(String aid, String orderid);

    public int getPeopleLimit(String orderid);

    public int followOrderBehaviour(String remark, String aid, String orderid, int addressId);

    public int followActivityBehaviour(String remark, String aid, String orderid, int addressId, int peopleLimit);

    public int getCurrentPeople(String orderid);
}
