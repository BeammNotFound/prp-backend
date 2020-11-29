package com.service.impl;

import com.common.utils.AddLoginTooken;
import com.common.utils.RedisUtil;
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
    private LoginMapper loginMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Map<String, Object> login(LoginVo user) {

        Map<String, Object> map = new HashMap<>();
        User login = loginMapper.login(user);

        if (login == null) {
            map.put("flag", false);
            return map;
        }

        //用户密码对比
        if (login.getUser_password().equals(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()))) {
            map.put("flag", true);
            new AddLoginTooken().addLoginTicket(login);
            login.setUser_password("**********");
            map.put("user_cookie", login);
            redisUtil.set("user_tooken", login.getUser_tooken());

        }else
            map.put("flag", false);

        return map;

    }

}
