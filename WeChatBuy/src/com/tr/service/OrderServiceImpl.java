package com.tr.service;

import com.google.gson.Gson;
import com.tr.dao.OrderDao;
import com.tr.dao.OrderDaoImpl;
import com.tr.dao.UserDao;
import com.tr.dao.UserDaoImpl;
import com.tr.domin.Follower;
import com.tr.domin.Order;
import com.tr.domin.PostOrderInfo;
import org.apache.commons.fileupload.FileItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderServiceImpl implements OrderService{

    private List<Order> hotOrderList;
    private List<Order> newOrderList;

    @Override
    //获得热门订单
    public List<Order> getHotOrderList(String com) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getHotOrderList(com);
    }



    @Override
    //获得最新订单
    public List<Order> getNewOrderList(String com) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getNewOrderList(com);
    }

    @Override
    //保存服务 返回json串
    public String savePic(String savePath, List<FileItem> list) {
        Logger logger = Logger.getLogger("Receiving Pic");
        logger.setLevel(Level.ALL);

        OrderDaoImpl orderDao = new OrderDaoImpl();
        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
            logger.info(savePath + "目录不存在 创建中");
            file.mkdir();
        }
        List<String> urls = orderDao.savePic(savePath, list);
        Gson gson = new Gson();
        String urlJson = gson.toJson(urls);
        logger.info("url Json:\n"+urlJson);
        return urlJson;
    }

    @Override
    public void uploadActivityInfo(PostOrderInfo postOrderInfo) {

        Logger log = Logger.getLogger("checkPostOrderInfo");
        log.setLevel(Level.ALL);
        log.info(postOrderInfo.getSavedPicSrc()+"\n"+postOrderInfo.getCom()+"\n"+postOrderInfo.getEndtime()+"\n"+postOrderInfo.getDesc()+"\n"+
                postOrderInfo.getPromulgatorid()+"\n"+postOrderInfo.getTheme()+"\n"+postOrderInfo.getPostTime());
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.uploadActivityInfo(postOrderInfo);
    }

    @Override
    public void uploadOrderInfo(PostOrderInfo postOrderInfo) {
        Logger log = Logger.getLogger("checkPostOrderInfo");
        log.setLevel(Level.ALL);
        log.info(postOrderInfo.getSavedPicSrc()+"\n"+postOrderInfo.getCom()+"\n"+postOrderInfo.getEndtime()+"\n"+postOrderInfo.getDesc()+"\n"+
                postOrderInfo.getPromulgatorid()+"\n"+postOrderInfo.getTheme()+"\n"+postOrderInfo.getPostTime());
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.uploadOrderInfo(postOrderInfo);
    }

    @Override
    public Order getDetailInfoById(String orderid) {
        OrderDao orderDao = new OrderDaoImpl();
        return orderDao.getDetailInfoById(orderid);
    }

    @Override
    public List<String> getPicUrls(String orderid) {
        OrderDao orderDao = new OrderDaoImpl();
        List<Object> urls = orderDao.getPicUrls(orderid);
        List<String> sLists = new ArrayList<String>();
        for (Object url : urls) {
            sLists.add((String) url);
        }
        return sLists;
    }

    @Override
    public List<Follower> getFollower(String orderid) {
        OrderDao orderDao = new OrderDaoImpl();
        return orderDao.getFollowerList(orderid);
    }

    @Override
    public boolean saveUserAvatar(String savePath, List<FileItem> list, String account) {
        UserDao userDao = new UserDaoImpl();
        int updates;
        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        String avatarUrl = userDao.saveUserAvatarPic(savePath, list);
//        System.out.println(avatarUrl+"=======》avatar url");
        if(!avatarUrl.equals("")) {
            updates = userDao.saveUserAvatarUrl(avatarUrl, account);
            return updates > 0 ? true : false;
        }
        else return false;

    }

    @Override
    public String followBehaviour(String remark, String aid, String orderid) {
        //TODO 检测用户是否已经跟过此单，如果有，返回错误信息数字，如果没有错误，检测跟单的是什么类型，活动还是订单 活动得判断是否超出人数上线

        OrderDao orderDao = new OrderDaoImpl();
        int addressId = orderDao.getUserAddressId(aid);
        boolean checkIsFollowed = orderDao.checkIsFollowed(aid, orderid);
        int peopleLimit = orderDao.getPeopleLimit(orderid);
        if (-1 == addressId) {
            //no addressid error
            return "未设置订单地址";
        }else if (checkIsFollowed){
            //跟单过 返回信息
            return "已经跟过此单";
        } else if (-1 == peopleLimit) {
            //跟单逻辑
            int rows = orderDao.followOrderBehaviour(remark, aid, orderid, addressId);
            return rows > 0 ? "跟踪订单成功": "跟踪订单失败";
        } else {
//            跟活动逻辑
            int rows = orderDao.followActivityBehaviour(remark, aid, orderid, addressId,peopleLimit);
            return rows > 0 ? "跟踪活动成功": "跟踪活动失败";
        }
    }
}
