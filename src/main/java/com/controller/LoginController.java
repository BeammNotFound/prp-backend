package com.controller;

import com.common.api.CommonResult;
import com.pojo.User;
import com.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "登录接口")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("验证用户登录信息")
    @PostMapping("/login")
    public CommonResult login(@ApiParam("输入用户凭据") @RequestBody User user){

        User sqlUser = loginService.login(user.getUser_name());
        try {
            String userType;
            if (sqlUser.getUser_type().equals(2)) {
                userType = "管理员";
            }else {
                userType = "普通用户";
            }
            if (sqlUser.getUser_password().equals(user.getUser_password())) {
                return CommonResult.success("登录成功","Welcome，"+sqlUser.getUser_nickname()+"，您的用户权限为："+userType);
            }
            return CommonResult.success("账号密码错误","登录失败");
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("服务器错误");
        }
    }


}
