package com.tr.dao;

import com.tr.domin.User;
import com.tr.utils.BaseDataUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        try {
            int update = queryRunner.update(sql, user.getPhone(), user.getPassword(), user.getAccount(), user.getEmail(), user.getIdentity());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String signInAccount(String account, String password) {
        String sql = "select cname from account,community,userinfo where account.aid=userinfo.aid and userinfo.com=community.cid and account=? and password=?";
        try {
//            System.out.println((int)(long)queryRunner.query(sql, new ScalarHandler(),account,password));
            return (String) queryRunner.query(sql, new ScalarHandler(),account,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
