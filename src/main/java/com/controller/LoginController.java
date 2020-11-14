package com.controller;

import com.common.api.CommonResult;
import com.common.api.IErrorCode;
import com.pojo.User;
import com.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Api(tags = "登录接口")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    @ApiOperation("验证用户登录信息")
    @PostMapping("/login")
    public CommonResult login(@ApiParam("输入用户凭据") @Validated @RequestBody User user, BindingResult result, Model model, HttpSession session){

        //判断是否为空
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                return CommonResult.validateFailed(error.getDefaultMessage());
            }
        }

        Map<String, Object> loginMap = loginService.login(user);

        if ((Boolean) loginMap.get("flag")) {
            session.setAttribute("loginUser",user.getUser_name());
            return CommonResult.success("登录成功!Welcome," + loginMap.get("user_name") + ",您的权限为：" + loginMap.get("user_type"));
        }
        model.addAttribute("msg", "用户名或者密码错误");
        return CommonResult.validateFailed("用户名密码错误");

    }


}
