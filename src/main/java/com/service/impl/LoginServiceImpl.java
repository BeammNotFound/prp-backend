package com.service.impl;

import com.mapper.LoginMapper;
import com.pojo.User;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public User login(String userName) {

        return loginMapper.login(userName);

    }



}
