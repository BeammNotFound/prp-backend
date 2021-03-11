package com.service.impl;

import com.common.utils.AddLoginTooken;
import com.common.utils.RedisUtil;
import com.mapper.BasesMapper;
import com.mapper.UserMapper;
import com.pojo.Bases;
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
    private UserMapper userMapper;

    @Autowired
    private BasesMapper basesMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Map<String, Object> login(LoginVo user) {

        Map<String, Object> map = new HashMap<>();
        User login = userMapper.queryUserByName(user.getUser_name());

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

    @Override
    public Bases loginInManage(LoginVo vo) {
        Bases bases = new Bases();
        bases.setBase_id(0);
        if (vo.getUser_password().equals("123456")) {
            switch (vo.getUser_name()) {
                case "user1":
                    return basesMapper.queryBasesById(1);
                case "user2":
                    return basesMapper.queryBasesById(2);
                case "user3":
                    return basesMapper.queryBasesById(3);
                default:
                    return bases;
            }
        }else
            return bases;
    }

}
