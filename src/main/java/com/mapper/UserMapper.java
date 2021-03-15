package com.mapper;

import com.pojo.User;
import com.pojo.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();
    void createUser(CreateUserVo user);
    void forgetPassword(ForgetPasswordVo user);
    void updateUserById(UpdateUserInfoVo vo);
    User queryUserByName(String user_name);
    void updatePasswordByUserName(UpdatePasswordVo updatePasswordVo);
    User queryUserById(Integer user_id);
    void addStarPet(PetStarVo vo);
    void delStarPet(PsIdVo vo);
}

