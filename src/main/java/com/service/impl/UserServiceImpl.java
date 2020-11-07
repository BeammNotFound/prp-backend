package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public String creatUser(User user) {
        mapper.creatUser(user);
        return "ok";
    }
}
