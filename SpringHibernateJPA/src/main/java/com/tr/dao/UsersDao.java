package com.tr.dao;

import com.tr.pojo.Users;

import java.util.List;

public interface UsersDao {
    void insertUsers(Users users);

    void updateUsers(Users users);

    void deleteUsers(Users users);

    Users selectUserById(int id);

    List<Users> selectUserByNameWithHql(String name);

    List<Users> selectUserByNameWithSql(String name);

    List<Users> selectUserByNameWithCriteria(String name);
}
