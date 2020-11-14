package com.controller;


import com.common.api.CommonResult;
import com.common.config.RedisUtil;
import com.common.tools.TimeUtils;
import com.common.tools.SetMail;
import com.pojo.User;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User管理接口")
@RestController
public class UserController {

    @Autowired
    private JavaMailSender javaMailSender;


    @Autowired
    private UserService service;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("查询全部用户信息")
    @GetMapping("/queryUserList")
    public CommonResult queryUserList() {
        return CommonResult.success(service.queryUserList());
    }

    @ApiOperation("添加用户")
    @PostMapping("/creatUser")
    public CommonResult createUser(@ApiParam("输入用户数据") @Validated @RequestBody User user, BindingResult result) {

//        判断是否为空
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                return CommonResult.validateFailed(error.getDefaultMessage());
            }
        }
        String code = redisUtil.get(user.getUser_mail());

        if (user.getMail_code().equals(code)) {
            user.setUser_updatetime(TimeUtils.getNowTime());
            user.setUser_createtime(TimeUtils.getNowTime());
            user.setUser_password(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()));

            if (user.getUser_type() == null){
                user.setUser_type(1);
            }

            service.createUser(user);
            return CommonResult.success("添加用户成功,用户名为：" + user.getUser_name());
        }
        return CommonResult.validateFailed("邮箱验证失败");

    }

    @ApiOperation("根据用户名修改用户信息")
    @PostMapping("/updateUserByUserName")
    public CommonResult updateUserByUserName(@ApiParam("输入用户名") @RequestBody User user) {

        user.setUser_updatetime(TimeUtils.getNowTime());
        service.updateUserByUserName(user);
        return CommonResult.success("修改成功");
    }

    @ApiOperation("修改密码")
    @PostMapping("/updatePassword")
    public CommonResult updatePassword(@ApiParam("输入用户名、原密码和新密码") @RequestBody User user) {
        user.setUser_updatetime(TimeUtils.getNowTime());
        Boolean flag = service.verifyPassword(user);
        if (flag) {
            user.setUser_password(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()));
            service.updateUserByUserName(user);
            return CommonResult.success("修改密码成功！");
        }
        return CommonResult.validateFailed("原密码不正确！");
    }

    @ApiOperation("忘记密码")
    @PostMapping("/forgetPassword")
    public CommonResult forgetPassword(@RequestBody User user) {
        user.setUser_updatetime(TimeUtils.getNowTime());
        user.setUser_password(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()));
        service.updateUserByUserName(user);
        return CommonResult.success("修改密码成功");
    }

    @ApiOperation("邮箱校验")
    @PostMapping("verifyMail")
    public CommonResult verifyMail(@RequestBody User user){
        if (user.getUser_mail().equals(null)) {
            return CommonResult.validateFailed("请输入邮箱");
        }
        SetMail setMail = new SetMail(javaMailSender, redisUtil);
        setMail.sendMail(user.getUser_mail());
        return CommonResult.success("邮箱发送成功");
    }




    private CommonResult NotNullVerify(User user) {

        if (user.getUser_name().equals("") && user.getUser_name() == null) {
            return CommonResult.validateFailed("用户名不能为空");
        } else if (user.getUser_password().equals("") && user.getUser_password() == null) {
            return CommonResult.success("密码不能为空");
        } else {
            return CommonResult.validateFailed("请检验输入的数据");
        }
    }
}
