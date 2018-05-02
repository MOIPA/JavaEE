package com.tr.dao;

import com.tr.domin.User;
import com.tr.utils.BaseDataUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao{

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
            long queryNumber = (long) queryRunner.query(sql, new ScalarHandler(),username);
            return queryNumber>0? true:false;
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
            int aid = (int)queryRunner.query(getAidSql, new ScalarHandler(),user.getAccount());
            int updateCommunity = queryRunner.update(updateCommunitySql, aid, user.getCname());
            if (update > 0 && updateCommunity> 0) {
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
            User user = queryRunner.query(sql, new BeanHandler<User>(User.class), account, password);
            try {
                System.out.println("user dao"+new String(user.getCname().getBytes(),"utf8")+"中文||"+user.getCname());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return user;
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
}
