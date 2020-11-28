package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.vo.*;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> queryUserList() {
        return mapper.queryUserList();
    }

    @Override
    public void createUser(CreateUserVo user) {
        mapper.createUser(user);
    }

    @Override
    public void forgetPassword(ForgetPasswordVo user) {
        mapper.forgetPassword(user);
    }

    @Override
    public void updateUserByUserName(User user) {
        mapper.updateUserByUserName(user);
    }

    @Override
    public Boolean userApplication(UserApplicationVo applicationVo) {
        if (applicationVo.getB_population() - applicationVo.getB_joinPopulation() <= 0 || applicationVo.getB_status() != 1) {
            return false;
        }
        mapper.userApplication(applicationVo);
        return true;
    }

    @Override
    public User queryUserByName(String user_name) {
        return mapper.queryUserByName(user_name);
    }

    @Override
    public QueryUserApplication queryUserApplication(QueryUserApplication queryUserApplication) {
        return mapper.queryUserApplication(queryUserApplication);
    }

    @Override
    public boolean verifyPassword(User user) {
        List<User> list = mapper.queryUserList();

        //密码效验
        for (User u: list) {
            if (DigestUtils.md5DigestAsHex(u.getUser_password().getBytes()).equals(DigestUtils.md5DigestAsHex(user.getEnter_password().getBytes()))) {
                return true;
            }
        }
        return false;

    }
}
