package com.tr.dao;

import com.google.gson.Gson;
import com.sun.deploy.net.HttpRequest;
import com.tr.domin.Order;
import com.tr.utils.BaseDataUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDaoImpl {
    private List<Order> hotOrderList;
    private List<Order> newOrderList;

    public List<Order> getHotOrderList(String com) {
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        String sql = "select count(follower.aid) as followers,ruserorderinfo3.* " +
                "from ruserorderinfo3,orderstatus,follower " +
                "where ruserorderinfo3.com=? and orderstatus!='待审核' " +
                "and ruserorderinfo3.orderid=follower.orderid " +
                "and ruserorderinfo3.orderid=orderstatus.orderid " +
                "group by ruserorderinfo3.orderid order by followers desc limit 9";
        try {
            hotOrderList = queryRunner.query(sql, new BeanListHandler<Order>(Order.class), com);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotOrderList;
    }

    public List<Order> getNewOrderList(String com) {
        String sql = "select count(follower.aid) as followers,ruserorderinfo3.*,orderstatus.* " +
                "from ruserorderinfo3,orderstatus,follower" +
                "where ruserorderinfo3.com=? " +
                "and ruserorderinfo3.orderid=follower.orderid " +
                "and ruserorderinfo3.orderid=orderstatus.orderid " +
                "group by ruserorderinfo3.orderid,orderstatus.orderstatus,orderstatus.peoplelimit,orderstatus.currentpeople";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            newOrderList = queryRunner.query(sql, new BeanListHandler<Order>(Order.class), com);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newOrderList;
    }

    /**
     * @param savePath 保存路径
     * @param list     文件项
     * @return 文件路径和名字列表 List
     */
    public List<String> savePic(String savePath, List<FileItem> list) {
        Logger logger = Logger.getLogger("Receiving Pic");
        logger.setLevel(Level.ALL);
        logger.info("开始处理上传文件");
        List<String> urlLists;
        try {
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            upload.setHeaderEncoding("UTF-8");
//            //判断是否为表单数据
//            if (!ServletFileUpload.isMultipartContent(request)) {
//                //按照传统方式获取数据  这些数据不做处理
//                return null;
//            }
//            List<FileItem> list = upload.parseRequest(request);
            urlLists = new ArrayList<String>();
            for (FileItem item : list) {
                if (item.isFormField()) {
                    //普通输入项
                    String name = item.getFieldName();
                    String value = item.getString("utf-8");
                    logger.info(name + "---" + value);
                } else {
                    //文件
                    String fileName = item.getName();
                    logger.info("文件名字" + fileName);
                    if (fileName == null || fileName.trim().equals("")) {
                        continue;
                    }
                    //有的浏览器上传的文件名带路径，有的不带 处理为不带的
                    fileName = fileName.substring(fileName.indexOf("\\") + 1);
                    InputStream inputStream = item.getInputStream();
                    FileOutputStream outputStream = new FileOutputStream(savePath + "\\" + fileName);
                    //创建缓冲区
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, len);
                    }
                    inputStream.close();
                    outputStream.close();
                    //删除缓存文件
                    item.delete();
                    logger.info("save path :"+savePath);
                    //从最后开始找路径
                    String parentDir = savePath.substring(savePath.lastIndexOf("\\") + 1);
                    logger.info("directory :"+parentDir);
                    urlLists.add(parentDir + "/" + fileName);

                }
            }
            return urlLists;

        } catch (Exception e) {

        }
        return null;
    }
}
