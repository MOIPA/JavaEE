package com.tr.service;

import com.tr.dao.UserDao;
import com.tr.dao.UserDaoImpl;
import com.tr.domin.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public boolean checkUserAccount(String username) {
        return userDao.checkUserAccount(username);
    }

    @Override
    public boolean signUpAcocunt(User user) {
        int dataLen = userDao.signUpAcocunt(user);
        boolean isSuccess = dataLen>0? true:false;
        return isSuccess;
    }

    @Override
    public User signInAccount(String account, String password) {
        User user = userDao.signInAccount(account, password);
        if(user!=null){
            return user;
        }
        return null;
    }
}
