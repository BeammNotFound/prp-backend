package com.service;

import com.pojo.User;
import com.pojo.vo.CreateUserVo;
import com.pojo.vo.ForgetPasswordVo;

import java.util.List;

public interface UserService{
    List<User> queryUserList();
    void createUser(CreateUserVo user);
    void forgetPassword(ForgetPasswordVo user);
    boolean verifyPassword(User user);
    void updateUserByUserName(User user);

}
