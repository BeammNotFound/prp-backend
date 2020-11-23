package com.controller;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.RedisUtil;
import com.pojo.User;
import com.pojo.vo.LoginVo;
import com.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Api(tags = "登录接口")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;


    @ApiOperation("验证用户登录信息")
    @Action()
    @PostMapping("/login")
    public CommonResult login(@ApiParam("输入用户凭据") @Validated @RequestBody LoginVo user, BindingResult result){

        //判断是否为空
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }

        Map<String, Object> loginMap = loginService.login(user);

        //如果用户密码对比成功
        if ((Boolean) loginMap.get("flag")) {
            User user_cookie = (User) loginMap.get("user_cookie");
            redisUtil.set("user_tooken", user_cookie.getUser_tooken());
            return CommonResult.success(user_cookie);
        }
        return CommonResult.validateFailed("用户名密码错误");

    }


}
