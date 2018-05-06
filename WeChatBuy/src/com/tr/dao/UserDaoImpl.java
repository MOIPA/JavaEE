package com.tr.dao;

import com.tr.domin.User;
import com.tr.utils.BaseDataUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.fileupload.FileItem;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner = BaseDataUtil.getQueryRunner();

    @Override
    public List<User> getUserList() {
        String sql = "select * from account";
        try {
            return queryRunner.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkUserAccount(String username) {
        String sql = "select count(*) from account where account=?";
        try {
            long queryNumber = (long) queryRunner.query(sql, new ScalarHandler(), username);
            return queryNumber > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int signUpAcocunt(User user) {
        String sql = "insert into account(phone,password,account,email,identity)values(?,?,?,?,?)";
        String getAidSql = "select aid from account where account=?";
        String updateCommunitySql = "insert into userinfo(aid,com)values(?,?)";
        try {
            int update = queryRunner.update(sql, user.getPhone(), user.getPassword(), user.getAccount(), user.getEmail(), user.getIdentity());
            int aid = (int) queryRunner.query(getAidSql, new ScalarHandler(), user.getAccount());
            int updateCommunity = queryRunner.update(updateCommunitySql, aid, user.getCname());
            if (update > 0 && updateCommunity > 0) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public User signInAccount(String account, String password) {
        String sql = "select account,phone,password,email,identity,account.aid,uiconsrc,cname " +
                "from account,community,userinfo " +
                "where account.aid=userinfo.aid and userinfo.com=community.cid and account=? and password=?";
        try {
//            System.out.println((int)(long)queryRunner.query(sql, new ScalarHandler(),account,password));
            return queryRunner.query(sql, new BeanHandler<User>(User.class), account, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> getAllCommunity() {
        String sql = "select * from community";
        try {
            return queryRunner.query(sql, new MapListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String saveUserAvatarPic(String savePath, List<FileItem> list) {
        Logger logger = Logger.getLogger("Receiving Pic");
        logger.setLevel(Level.ALL);
        logger.info("开始处理上传头像");
        String avatarUrl = "";
        try {
            for (FileItem item : list) {
                if (item.isFormField()) {
                    logger.info("开始处理普通项目");
                    //普通输入项
                    String name = item.getFieldName();
                    String value = item.getString("utf-8");
                    logger.info(name + "---" + value);
                } else {
                    logger.info("开始处理文件项目");
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
                    avatarUrl = "/" + fileName;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("上传头像处理完毕");
        return avatarUrl;
    }

    @Override
    public int saveUserAvatarUrl(String avatarUrl, String account) {
        String sql = "update account set uiconsrc=? where account = ? ";
        System.out.println(avatarUrl + ":" + account);
        QueryRunner queryRunner = BaseDataUtil.getQueryRunner();
        try {
            return queryRunner.update(sql, avatarUrl, account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
