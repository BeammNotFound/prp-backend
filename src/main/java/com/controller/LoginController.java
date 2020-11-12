package com.controller;

import com.common.api.CommonResult;
import com.pojo.User;
import com.service.LoginService;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "登录接口")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    @ApiOperation("验证用户登录信息")
    @PostMapping("/login")
    public CommonResult login(@ApiParam("输入用户凭据") @RequestBody User user){

        Map<String, Object> loginMap = loginService.login(user);

        if ((Boolean) loginMap.get("flag"))
            return CommonResult.success("登录成功!Welcome,"+loginMap.get("user_name")+",您的权限为："+loginMap.get("user_type"));

        return CommonResult.success("账号密码错误","登录失败");
    }


}
