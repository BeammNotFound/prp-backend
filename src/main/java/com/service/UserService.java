package com.service;

import com.pojo.User;
import com.pojo.vo.*;

public interface UserService{
    Object queryUserList();
    Boolean createUser(CreateUserVo user);
    Boolean forgetPassword(ForgetPasswordVo user);
    boolean verifyPassword(UpdatePasswordVo updatePasswordVo);
    void updateUserByUserName(User user);

    void updatePasswordByUserName(UpdatePasswordVo updatePasswordVo);

    Boolean userApplication(UserApplicationVo applicationVo);

    User queryUserByName(String user_name);

    QueryUserApplication queryUserApplication(Integer user_id);


}
