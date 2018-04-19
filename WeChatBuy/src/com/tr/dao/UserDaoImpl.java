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
}
