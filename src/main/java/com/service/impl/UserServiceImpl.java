package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public List<User> queryUserList() {
        return mapper.queryUserList();
    }

    @Override
    public void createUser(User user) {
        mapper.createUser(user);
    }

    @Override
    public void updateUserByUserName(User user) {
        mapper.updateUserByUserName(user);
    }

    @Override
    public boolean verifyPassword(User user) {
        List<User> list = mapper.queryUserList();

        for (User u: list) {
            if (DigestUtils.md5DigestAsHex(u.getUser_password().getBytes()).equals(DigestUtils.md5DigestAsHex(user.getEnter_password().getBytes()))) {
                return true;
            }
        }
        return false;

    }
}
