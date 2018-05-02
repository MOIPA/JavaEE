package com.tr.service;

import com.google.gson.Gson;
import com.tr.dao.OrderDaoImpl;
import com.tr.domin.Order;
import com.tr.domin.PostOrderInfo;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderService {

    private List<Order> hotOrderList;
    private List<Order> newOrderList;

    //获得热门订单
    public List<Order> getHotOrderList(String com) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getHotOrderList(com);
    }

    //获得最新订单
    public List<Order> getNewOrderList(String com) {
        OrderDaoImpl dao = new OrderDaoImpl();
        return dao.getNewOrderList(com);
    }

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

    public void uploadOrderInfo(PostOrderInfo postOrderInfo) {

        System.out.println(postOrderInfo.getSavedPicSrc()+"\n"+postOrderInfo.getCom()+"\n"+postOrderInfo.getEndtime()+"\n"+postOrderInfo.getDesc()+"\n"+
        postOrderInfo.getPromulgatorid()+"\n"+postOrderInfo.getTheme()+"\n"+postOrderInfo.getPostTime());

//        OrderDaoImpl orderDao = new OrderDaoImpl();
//        orderDao.uploadOrderInfo(postOrderInfo);
    }
}
