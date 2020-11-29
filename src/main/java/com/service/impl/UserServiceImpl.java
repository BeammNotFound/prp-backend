package com.service.impl;

import com.common.utils.RedisUtil;
import com.common.utils.TimeUtils;
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

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Object queryUserList() {
        if (redisUtil.hasKey("allUsers"))
            return redisUtil.get("allUsers");
        else
            redisUtil.set("allUsers", mapper.queryUserList(), 30);
            return redisUtil.get("allUsers");
    }

    @Override
    public Boolean createUser(CreateUserVo user) {
        String mail = user.getUser_mail();

        if (user.getMail_code().equals(redisUtil.get(mail))) {
            user.setUser_updatetime(TimeUtils.getNowTime());
            user.setUser_createtime(TimeUtils.getNowTime());
            user.setUser_password(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()));
            user.setUser_name(mail);
            user.setUser_type(1);

            redisUtil.del(mail);
            mapper.createUser(user);
            return true;
        }
        return false;

    }

    @Override
    public Boolean forgetPassword(ForgetPasswordVo user) {
        if (user.getMail_code().equals(redisUtil.get(user.getUser_mail()))) {
            user.setUser_updatetime(TimeUtils.getNowTime());
            user.setUser_password(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()));
            return true;
        }
        return false;
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
