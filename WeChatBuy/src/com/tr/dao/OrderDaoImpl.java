package com.tr.dao;

import com.tr.domin.Follower;
import com.tr.domin.Order;
import com.tr.domin.PostOrderInfo;
import com.tr.utils.BaseDataUtil;
import com.tr.utils.CommonUtil;
import com.tr.utils.LogUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.fileupload.FileItem;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDaoImpl implements OrderDao {
    private List<Order> hotOrderList;
    private List<Order> newOrderList;

    public List<Order> getHotOrderList(String com) {
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        String sql = "select orderstatus.peoplelimit,orderstatus.currentpeople,orderstatus.orderstatus,main.*," +
                "(select count(*) from follower where orderid=main.orderid) as followers " +
                " from ruserorderinfo3 main,orderstatus " +
                " where main.com=? and orderstatus.orderstatus!='待审核' and orderstatus.orderstatus!='活动'" +
                " and orderstatus.orderid = main.orderid " +
                " group by main.orderid,orderstatus.peoplelimit,orderstatus.currentpeople,orderstatus.orderstatus " +
                " limit 9";
        try {
            hotOrderList = queryRunner.query(sql, new BeanListHandler<Order>(Order.class), com);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotOrderList;
    }


    public List<Order> getNewOrderList(String com) {
        String sql = "select orderstatus.peoplelimit,orderstatus.currentpeople,orderstatus.orderstatus,main.*," +
                "(select count(*) from follower where orderid=main.orderid) as followers " +
                " from ruserorderinfo3 main,orderstatus " +
                " where main.com=? and orderstatus.orderstatus='活动' and orderstatus.orderid = main.orderid " +
                " group by main.orderid,orderstatus.peoplelimit,orderstatus.currentpeople,orderstatus.orderstatus " +
                " limit 9";
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
            urlLists.clear();
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
                    logger.info("save path :" + savePath);
                    //从最后开始找路径
                    String parentDir = savePath.substring(savePath.lastIndexOf("\\") + 1);
                    logger.info("directory :" + parentDir);
//                    urlLists.add(parentDir + "/" + fileName);
                    urlLists.add("/" + fileName);

                }
            }
            return urlLists;

        } catch (Exception e) {

        }
        return null;
    }

    public boolean uploadActivityInfo(PostOrderInfo postOrderInfo) {

        List<String> urlList = CommonUtil.splitUrl(postOrderInfo.getSavedPicSrc());
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        String basicOrderSql = "insert into theorder(promulgatorid,com,ordercontent,posttime,ordertime,ordertheme)values(?,?,?,?,?,?)";
        String getOrderIdSql = "select orderid from theorder where promulgatorid=? and com=? and posttime=?";
        String setStatusSql = "insert into orderstatus(orderid,orderstatus,peoplelimit,currentpeople)values(?,?,?,?)";
        String insertPicSql = "insert into orderpic(orderid,orderpicsrc)values(?,?)";
        try {
            int update = queryRunner.update(basicOrderSql, postOrderInfo.getPromulgatorid(), postOrderInfo.getCom(), postOrderInfo.getDesc(), postOrderInfo.getPostTime()
                    , postOrderInfo.getEndtime(), postOrderInfo.getTheme());
            if (update > 0) {
                //basic info insert succeed
                LogUtil.initLog("activity").info("insert basic order info succeed");
                //next
                int orderId = (int) queryRunner.query(getOrderIdSql, new ScalarHandler(), postOrderInfo.getPromulgatorid(), postOrderInfo.getCom(), postOrderInfo.getPostTime());
                LogUtil.initLog("activity").info("activity id goted : " + orderId);
                //next
                int orderStatus = queryRunner.update(setStatusSql, orderId, "活动", postOrderInfo.getPeoplelimit(), 0);
                if (orderStatus > 0) LogUtil.initLog("activity").info("activity status setted");

                for (int i = 0; i < urlList.size(); i++) {
                    int insertPic = queryRunner.update(insertPicSql, orderId, urlList.get(i));
                    if (insertPic > 0) LogUtil.initLog("activity").info(urlList.get(i) + " inserted");
                }
            } else {
                LogUtil.initLog("activity").info("insert basic activity info error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int uploadOrderInfo(PostOrderInfo postOrderInfo) {
        List<String> urlList = CommonUtil.splitUrl(postOrderInfo.getSavedPicSrc());
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        int orderId = -1;
        String basicOrderSql = "insert into theorder(promulgatorid,com,ordercontent,posttime,ordertime,ordertheme)values(?,?,?,?,?,?)";
        String getOrderIdSql = "select orderid from theorder where promulgatorid=? and com=? and posttime=?";
        String setStatusSql = "insert into orderstatus(orderid,orderstatus)values(?,?)";
        String insertPicSql = "insert into orderpic(orderid,orderpicsrc)values(?,?)";
        try {
            int update = queryRunner.update(basicOrderSql, postOrderInfo.getPromulgatorid(), postOrderInfo.getCom(), postOrderInfo.getDesc(), postOrderInfo.getPostTime()
                    , postOrderInfo.getEndtime(), postOrderInfo.getTheme());
            if (update > 0) {
                //basic info insert succeed
                LogUtil.initLog("activity").info("insert basic order info succeed");
                //next
                orderId = (int) queryRunner.query(getOrderIdSql, new ScalarHandler(), postOrderInfo.getPromulgatorid(), postOrderInfo.getCom(), postOrderInfo.getPostTime());
                LogUtil.initLog("activity").info("activity id goted : " + orderId);
                //next
                int orderStatus = queryRunner.update(setStatusSql, orderId, "待审核");
                if (orderStatus > 0) LogUtil.initLog("activity").info("activity status setted");

                for (int i = 0; i < urlList.size(); i++) {
                    int insertPic = queryRunner.update(insertPicSql, orderId, urlList.get(i));
                    if (insertPic > 0) LogUtil.initLog("activity").info(urlList.get(i) + " inserted");
                }
            } else {
                LogUtil.initLog("activity").info("insert basic activity info error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderId;
    }

    @Override
    public Order getDetailInfoById(String orderid) {
        String sql = "select orderstatus.peoplelimit,orderstatus.currentpeople,orderstatus.orderstatus,main.*," +
                "(select count(*) from follower where orderid=main.orderid) as followers " +
                " from ruserorderinfo3 main,orderstatus " +
                " where main.orderid=? and orderstatus.orderid = main.orderid " +
                " group by main.orderid,orderstatus.peoplelimit,orderstatus.currentpeople,orderstatus.orderstatus ";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            return queryRunner.query(sql, new BeanHandler<Order>(Order.class), orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> getPicUrls(String orderid) {

        String sql = "select * from orderpic where orderid = ?";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            return queryRunner.query(sql, new ColumnListHandler("orderpicsrc"), orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Follower> getFollowerList(String orderid) {
        String sql = "select follower.*,account.uiconsrc,account.account " +
                "from follower,account where orderid=? and follower.aid=account.aid";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            return queryRunner.query(sql, new BeanListHandler<Follower>(Follower.class), orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getUserAddressId(String aid) {
//        System.out.println(aid);
        String sql = "select addressid from useraddress where aid=?";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            Object result = queryRunner.query(sql, new ScalarHandler(), aid);
            if (result == null) {
                return -1;
            } else {
//                System.out.println((int)result+"************");
                return (int) result;
            }

        } catch (SQLException e) {
        }

        return -1;
    }

    @Override
    public int followBehaviour(String remark, String aid, String orderid, int addressId) {

        String sql = "insert into follower(orderid,aid,remark,urstatus,addressid)values(?,?,?,?,?)";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            return queryRunner.update(sql, orderid, aid, remark, "未付款", addressId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean checkIsFollowed(String aid, String orderid) {
        String sql = "select aid from follower where aid=? and orderid=?";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        Object result = null;
        try {
            result = queryRunner.query(sql, new ScalarHandler(), aid, orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }//true  已经跟过 false 未跟单
        return result == null ? false : true;
    }

    @Override
    public int getPeopleLimit(String orderid) {
        String sql = "select peoplelimit from orderstatus where orderid=?";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        Object result = null;
        try {
            result = queryRunner.query(sql, new ScalarHandler(), orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == null) return -1;
        else return (int) result;
    }

    @Override
    public int followOrderBehaviour(String remark, String aid, String orderid, int addressId, String byerPayUrl) {
        String sql = "insert into follower(orderid,aid,remark,urstatus,addressid)values(?,?,?,?,?)";
        String ByerPayCodeSql = "insert into ByerPayPic(aid,picurl)values(?,?)";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            queryRunner.update(ByerPayCodeSql, aid, byerPayUrl);
            return queryRunner.update(sql, orderid, aid, remark, "参加活动", addressId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int followActivityBehaviour(String remark, String aid, String orderid, int addressId, int peopleLimit) {

        String sql = "insert into follower(orderid,aid,remark,urstatus,addressid)values(?,?,?,?,?)";
        String updatePeopleSql = "update orderstatus set currentpeople=currentpeople+1 where orderid=?";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            queryRunner.update(updatePeopleSql, orderid);
            return queryRunner.update(sql, orderid, aid, remark, "未付款", addressId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int getCurrentPeople(String orderid) {
        String sql = "select currentPeople from orderstatus where orderid=?";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        Object result = null;
        try {
            result = queryRunner.query(sql, new ScalarHandler(), orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == null) return -1;
        else return (int) result;
    }

    @Override
    public List<Order> getUnPassedOrderListByCname(String cname) {
        String sql = "select * from ruserorderinfo3,orderstatus where ruserorderinfo3.com=? and orderstatus='待审核' and ruserorderinfo3.orderid=orderstatus.orderid";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            return queryRunner.query(sql, new BeanListHandler<Order>(Order.class), cname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> getPassedOrderListByCname(String cname) {
        String sql = "select * from ruserorderinfo3,orderstatus where ruserorderinfo3.com=? and orderstatus!='待审核' and ruserorderinfo3.orderid=orderstatus.orderid";
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            return queryRunner.query(sql, new BeanListHandler<Order>(Order.class), cname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int passBehaviour(String orderid) {
        String sql = "update orderstatus set orderstatus='进行中' where orderid = ?";
        try {
            return BaseDataUtil.getQueryRunner().update(sql, orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Order> getMyFollowedOrder(String aid) {
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        String sql = "select * from ruserorderinfo3,orderstatus " +
                " where ruserorderinfo3.orderid = orderstatus.orderid " +
                " and orderstatus.orderstatus!='活动已结束' " +
                " and ruserorderinfo3.orderid in(select orderid from follower where aid=?)";
        try {
            return queryRunner.query(sql, new BeanListHandler<Order>(Order.class), aid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> getMyPostedOrder(String aid) {
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        String sql = "select * from ruserorderinfo3,orderstatus " +
                " where promulgatorid=? " +
                " and orderstatus.orderstatus!='活动已结束' " +
                " and ruserorderinfo3.orderid = orderstatus.orderid";
        try {
            return queryRunner.query(sql, new BeanListHandler<Order>(Order.class), aid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getPayCode(String orderId) {
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        String sql = "select barcodeurl from orderBarcode where orderid=?";
        try {
           return (String) queryRunner.query(sql, new ScalarHandler(), orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }


}
