package com.service;

import com.pojo.Bases;
import com.pojo.vo.LoginVo;

import java.util.Map;


public interface LoginService {
    Map<String, Object> login(LoginVo user);
    Bases loginInManage(LoginVo vo);
}
