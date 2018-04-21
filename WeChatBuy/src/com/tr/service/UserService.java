package com.tr.service;

import com.tr.domin.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();

    public boolean checkUserAccount(String username);

    public boolean signUpAcocunt(User user);

    User signInAccount(String account, String password);
}
