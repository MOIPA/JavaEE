package com.tr.service;

import com.tr.dao.UserDaoImpl;
import com.tr.domin.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public boolean checkUserAccount(String username) {
        return userDao.checkUserAccount(username);
    }
}
