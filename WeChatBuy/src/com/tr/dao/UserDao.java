package com.tr.dao;

import com.tr.domin.User;

import java.util.List;

public interface UserDao {
    public List<User> getUserList();
    public boolean checkUserAccount(String username);
}
