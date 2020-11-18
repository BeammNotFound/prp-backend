package com.controller;


import com.common.api.CommonResult;
import com.common.utils.RedisUtil;
import com.common.utils.TimeUtils;
import com.common.utils.SetMail;
import com.pojo.User;
import com.pojo.vo.CreateUserVo;
import com.pojo.vo.ForgetPasswordVo;
import com.pojo.vo.VerifyMailVo;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User管理接口")
@RestController
public class UserController {

    @Autowired
    private SetMail setMail;

    @Autowired
    private UserService service;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @ApiOperation("查询全部用户信息")
    @GetMapping("/queryUserList")
    public CommonResult queryUserList() {
        return CommonResult.success(service.queryUserList());
    }

    @ApiOperation("添加用户")
    @PostMapping("/creatUser")
    public CommonResult createUser(@ApiParam("输入用户数据") @Validated @RequestBody CreateUserVo user, BindingResult result) {

//        判断是否为空
        if (result.hasErrors()) {
           return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        String mail = user.getUser_mail();
        user.setUser_name(mail);

        //判断验证码
        if (user.getMail_code().equals(redisUtil.get(mail))) {
            user.setUser_updatetime(TimeUtils.getNowTime());
            user.setUser_createtime(TimeUtils.getNowTime());
            user.setUser_password(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()));

            if (user.getUser_type() == null){
                user.setUser_type(1);
            }
            service.createUser(user);
            redisUtil.del(mail);
            return CommonResult.success("添加用户成功,昵称为：" + user.getUser_nickname());
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
    public CommonResult forgetPassword(@Validated @RequestBody ForgetPasswordVo user, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        if (user.getMail_code().equals(redisUtil.get(user.getUser_mail()))) {
            user.setUser_updatetime(TimeUtils.getNowTime());
            user.setUser_password(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()));

            service.forgetPassword(user);
            return CommonResult.success("修改密码成功");
        }

        return CommonResult.validateFailed("修改密码失败，请输入正确的验证码");

    }

    @ApiOperation("邮箱校验")
    @PostMapping("verifyMail")
    public CommonResult verifyMail(@Validated @RequestBody VerifyMailVo user, BindingResult result){

        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        setMail.sendMail(user.getUser_mail());
        return CommonResult.success("邮箱发送成功");
    }

}
