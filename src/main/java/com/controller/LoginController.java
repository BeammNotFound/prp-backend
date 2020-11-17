package com.controller;

import com.alibaba.fastjson.JSON;
import com.common.api.CommonResult;
import com.common.api.IErrorCode;
import com.pojo.User;
import com.pojo.vo.LoginVo;
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
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.Map;

@Api(tags = "登录接口")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    @ApiOperation("验证用户登录信息")
    @PostMapping("/login")
    public CommonResult login(@ApiParam("输入用户凭据") @Validated @RequestBody LoginVo user, BindingResult result, HttpServletResponse response){

        //判断是否为空
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }

        Map<String, Object> loginMap = loginService.login(user);

        //如果用户密码对比成功
        if ((Boolean) loginMap.get("flag")) {
//            String user_cookie = JSON.toJSONString(loginMap.get("user_cookie"));
//            System.out.println(user_cookie);
//            Cookie cookie = new Cookie("user_session",user_cookie);
//
//            response.addCookie(cookie);

//            return CommonResult.success("登录成功!Welcome," + loginMap.get("user_nickname") + ",您的权限为：" + loginMap.get("user_type"));

            return CommonResult.success(loginMap.get("user_cookie"));

        }
        return CommonResult.validateFailed("用户名密码错误");

    }


}
