package com.service;

import com.pojo.User;

import java.util.Map;


public interface LoginService {
    Map<String, Object> login(User user);
}
