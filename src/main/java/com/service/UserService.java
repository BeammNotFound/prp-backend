package com.service;

import com.pojo.User;

import java.util.List;

public interface UserService{
    List<User> queryUserList();
    void createUser(User user);
    void updateUserByUserName(User user);
    boolean verifyPassword(User user);
}
