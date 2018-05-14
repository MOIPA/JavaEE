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
    public int uploadOrderInfo(PostOrderInfo postOrderInfo) {
        Logger log = Logger.getLogger("checkPostOrderInfo");
        log.setLevel(Level.ALL);
        log.info(postOrderInfo.getSavedPicSrc()+"\n"+postOrderInfo.getCom()+"\n"+postOrderInfo.getEndtime()+"\n"+postOrderInfo.getDesc()+"\n"+
                postOrderInfo.getPromulgatorid()+"\n"+postOrderInfo.getTheme()+"\n"+postOrderInfo.getPostTime());
        OrderDaoImpl orderDao = new OrderDaoImpl();
        return orderDao.uploadOrderInfo(postOrderInfo);
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

    /**
     *  0 表示跟单成功，1表示参与活动成功，-1 表示未设置地址，-2 表示已经参与过跟单，-3表示参与的活动人数已满
     *  -11表示执行失败
     * @param remark
     * @param aid
     * @param orderid
     * @param byerPayUrl
     * @return
     */
    @Override
    public int followBehaviour(String remark, String aid, String orderid, String byerPayUrl) {
        //TODO 检测用户是否已经跟过此单，如果有，返回错误信息数字，如果没有错误，检测跟单的是什么类型，活动还是订单 活动得判断是否超出人数上线

        OrderDao orderDao = new OrderDaoImpl();
        int addressId = orderDao.getUserAddressId(aid);
        boolean checkIsFollowed = orderDao.checkIsFollowed(aid, orderid);
        int peopleLimit = orderDao.getPeopleLimit(orderid);
        Logger logger = Logger.getLogger("follow");
        logger.info("地址信息："+addressId+" 是否参与："+checkIsFollowed+" 人数限制："+peopleLimit);

        if (-1 == addressId) {
            //no addressid error
            return -1;
        }else if (checkIsFollowed){
            //跟单过 返回信息
            return -2;
        } else if (-1 == peopleLimit) {
            //跟单逻辑
            int rows = orderDao.followOrderBehaviour(remark, aid, orderid, addressId,byerPayUrl);
            return rows > 0 ? 0: -11;
        } else if (-1 != peopleLimit){
//            跟活动逻辑
            int currentPeople = orderDao.getCurrentPeople(orderid);
            if(currentPeople>=peopleLimit) return -3;
            int rows = orderDao.followActivityBehaviour(remark, aid, orderid, addressId,peopleLimit);
            return rows > 0 ? 1: -11;
        }
        return -11;
    }

    @Override
    public List<Order> getUnPassedOrderListByCname(String cname) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getUnPassedOrderListByCname(cname);
    }

    @Override
    public List<Order> getPassedOrderListByCname(String cname) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getPassedOrderListByCname(cname);
    }

    @Override
    public boolean passBehaviour(String orderid) {
        OrderDao orderDao = new OrderDaoImpl();
        int rows = orderDao.passBehaviour(orderid);
        return rows>0?true:false;
    }

    @Override
    public List<Order> getMyFollowedOrder(String aid) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getMyFollowedOrder(aid);
    }

    @Override
    public List<Order> getMyPostedOrder(String aid) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getMyPostedOrder(aid);
    }

    @Override
    public boolean saveUserPayCode(String savePath, List<FileItem> list, String orderId) {
        UserDao userDao = new UserDaoImpl();
        int updates;
        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        String payCodeUrl = userDao.saveUserPayCodePic(savePath, list);
//        System.out.println(avatarUrl+"=======》avatar url");
        if(!payCodeUrl.equals("")) {
            updates = userDao.saveUserPayCodeUrl(payCodeUrl, orderId);
            return updates > 0 ? true : false;
        }
        else return false;
    }

    @Override
    public String getPayCode(String orderId) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getPayCode(orderId);
    }

    @Override
    public String saveByerPayUrl(String savePath, List<FileItem> list, String orderId) {
        UserDao userDao = new UserDaoImpl();
        int updates;
        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        return userDao.saveByerPayCodePic(savePath, list);

    }
}
