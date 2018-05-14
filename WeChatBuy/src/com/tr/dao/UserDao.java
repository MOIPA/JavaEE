package com.tr.dao;

import com.tr.domin.User;
import com.tr.domin.UserPay;
import org.apache.commons.fileupload.FileItem;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> getUserList();

    public boolean checkUserAccount(String username);

    public int signUpAcocunt(User user);

    User signInAccount(String account, String password);

    List<Map<String, Object>> getAllCommunity();

    public String saveUserAvatarPic(String savePath, List<FileItem> list);

    public int saveUserAvatarUrl(String avatarUrl, String aid);

    public String saveUserPayCodePic(String savePath, List<FileItem> list);

    public int saveUserPayCodeUrl(String avatarUrl, String account);

    public String saveByerPayCodePic(String savePath, List<FileItem> list);

}
