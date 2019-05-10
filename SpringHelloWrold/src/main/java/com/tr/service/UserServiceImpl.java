package com.tr.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class UserServiceImpl implements UserService{
    public void save() {
        System.out.println("save");
    }
    public void delete() {
        System.out.println("delete");
    }
    public void update() {
        System.out.println("update");
    }
    public void get() {
        System.out.println("get");
    }
}
