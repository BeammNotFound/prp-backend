package com.controller;


import com.common.api.CommonResult;
import com.common.api.TimeUtils;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(tags = "User管理接口")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation("查询全部用户信息")
    @GetMapping("/queryUserList")
    public CommonResult queryUserList() {
        try {
            return CommonResult.success(service.queryUserList());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("服务器错误");
        }
    }

    @ApiOperation("添加用户")
    @PostMapping("/creatUser")
    public CommonResult createUser(@ApiParam("输入用户数据") @RequestBody User user){

        user.setUser_creattime(TimeUtils.getNowTime());
        user.setUser_updatetime(TimeUtils.getNowTime());
        if (user.getUser_type() == null)
            user.setUser_type(1);

        try {
            service.createUser(user);
            return CommonResult.success("添加用户成功,用户名为："+user.getUser_name());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("服务器错误");
        }
    }
}
