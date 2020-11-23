package com.service.impl;

import com.common.utils.AddLoginTooken;
import com.mapper.LoginMapper;
import com.pojo.User;
import com.pojo.vo.LoginVo;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public Map<String, Object> login(LoginVo user) {

        Map<String, Object> map = new HashMap<>();
        User login = loginMapper.login(user);

        if (login == null) {
            map.put("flag", false);
            return map;
        }
        if ((login.getUser_type()).equals(2)) {
            map.put("user_type", "管理员用户");
        }else {
            map.put("user_type","普通用户");
        }
        //用户密码对比
        if (login.getUser_password().equals(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()))) {
            map.put("flag", true);
            new AddLoginTooken().addLoginTicket(login);

        }else
            map.put("flag", false);
        login.setUser_password("**********");
        map.put("user_cookie", login);
        return map;

    }

}
