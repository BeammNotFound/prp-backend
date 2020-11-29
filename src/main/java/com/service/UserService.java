package com.service;

import com.pojo.User;
import com.pojo.vo.*;

public interface UserService{
    Object queryUserList();
    Boolean createUser(CreateUserVo user);
    Boolean forgetPassword(ForgetPasswordVo user);
    boolean verifyPassword(User user);
    void updateUserByUserName(User user);
    Boolean userApplication(UserApplicationVo applicationVo);

    User queryUserByName(String user_name);

    QueryUserApplication queryUserApplication(QueryUserApplication queryUserApplication);


}
