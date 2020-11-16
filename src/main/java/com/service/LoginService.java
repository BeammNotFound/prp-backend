package com.service;

import com.pojo.User;
import com.pojo.vo.LoginVo;

import java.util.Map;


public interface LoginService {
    Map<String, Object> login(LoginVo user);
}
