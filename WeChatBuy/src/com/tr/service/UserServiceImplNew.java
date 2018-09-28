package com.tr.service;

import com.tr.domin.User;

import java.util.List;

public class UserServiceImplNew implements UserService {
    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public boolean checkUserAccount(String username) {
        return false;
    }

    @Override
    public boolean signUpAcocunt(User user) {
        return false;
    }

    @Override
    public User signInAccount(String account, String password) {
        return null;
    }

    @Override
    public String getAllCommunity() {
        return null;
    }

    @Override
    public boolean signoff() {
        return false;
    }
}
