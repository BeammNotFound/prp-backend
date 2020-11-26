package com.service;

import com.pojo.User;
import com.pojo.vo.*;

import java.util.List;

public interface UserService{
    List<User> queryUserList();
    void createUser(CreateUserVo user);
    void forgetPassword(ForgetPasswordVo user);
    boolean verifyPassword(User user);
    void updateUserByUserName(User user);
    Boolean userApplication(UserApplicationVo applicationVo);

    User queryUserByName(String user_name);

    QueryUserApplication queryUserApplication(QueryUserApplication queryUserApplication);


}
