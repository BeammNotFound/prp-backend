package com.service;

import com.pojo.User;
import com.pojo.vo.*;

public interface UserService{
    Object queryUserList();
    Boolean createUser(CreateUserVo user);
    Boolean forgetPassword(ForgetPasswordVo user);
    boolean verifyPassword(UpdatePasswordVo updatePasswordVo);
    void updateUserByUserId(UpdateUserInfoVo vo);
    void updatePasswordByUserName(UpdatePasswordVo updatePasswordVo);
    User queryUserByName(String user_name);
    User queryUserById(Integer user_id);
    void addStarPet(PetStarVo vo);
    void delStarPet(PsIdVo vo);
}
