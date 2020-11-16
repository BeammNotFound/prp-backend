package com.mapper;

import com.pojo.User;
import com.pojo.vo.CreateUserVo;
import com.pojo.vo.ForgetPasswordVo;
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
}

