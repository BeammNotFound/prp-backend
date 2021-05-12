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

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Object queryUserList() {
        if (redisUtil.hasKey("allUsers")) {
            return redisUtil.get("allUsers");
        }
        else {
            redisUtil.set("allUsers", mapper.queryUserList(), 30);
            return redisUtil.get("allUsers");
        }
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

            user.setUser_icon("https://img.imgdb.cn/item/6075a03a8322e6675c88a1b5.png");
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
    public void updateUserByUserId(UpdateUserInfoVo vo) {
        mapper.updateUserById(vo);
    }

    @Override
    public void updatePasswordByUserName(UpdatePasswordVo updatePasswordVo) {
        mapper.updatePasswordByUserName(updatePasswordVo);
    }

    @Override
    public User queryUserByName(String user_name) {
        return mapper.queryUserByName(user_name);
    }

    @Override
    public User queryUserById(Integer user_id) {
        return mapper.queryUserById(user_id);
    }

    @Override
    public void addStarPet(PetStarVo vo) {
        vo.setPs_create_time(TimeUtils.getNowTime());
        mapper.addStarPet(vo);
    }

    @Override
    public void delStarPet(PsIdVo vo) {
        mapper.delStarPet(vo);
    }


    @Override
    public boolean verifyPassword(UpdatePasswordVo updatePasswordVo) {

        //密码效验
        if (mapper.queryUserByName(updatePasswordVo.getUser_name()).getUser_password().equals(DigestUtils.md5DigestAsHex(updatePasswordVo.getEnter_password().getBytes()))) {
            return true;
        }
        return false;

    }
}
