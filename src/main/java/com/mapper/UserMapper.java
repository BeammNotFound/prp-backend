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
    void updateUserByUserName(User user);
    void updatePasswordByUserName(UpdatePasswordVo updatePasswordVo);
    void userApplication(UserApplicationVo applicationVo);
    User queryUserByName(String user_name);
    QueryUserApplication queryUserApplication(Integer user_id);

}

