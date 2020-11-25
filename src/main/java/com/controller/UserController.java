package com.controller;


import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.RedisUtil;
import com.common.utils.TimeUtils;
import com.common.utils.SetMail;
import com.pojo.Bases;
import com.pojo.User;
import com.pojo.vo.CreateUserVo;
import com.pojo.vo.ForgetPasswordVo;
import com.pojo.vo.UserApplicationVo;
import com.pojo.vo.VerifyMailVo;
import com.service.BasesService;
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

@Api(tags = "用户管理接口")
@RestController
public class UserController {

    @Autowired
    private SetMail setMail;

    @Autowired
    private UserService userService;

    @Autowired
    private BasesService basesService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @ApiOperation("查询全部用户信息")
    @Action(description = "查询全部用户信息")
    @GetMapping("/queryUserList")
    public CommonResult queryUserList() {

        //存入redis
        if (redisUtil.hasKey("allUsers")) {
            return CommonResult.success(redisUtil.get("allUsers"));
        }else {
            redisUtil.set("allUsers", userService.queryUserList(),30);
        }
        return CommonResult.success(redisUtil.get("allUsers"));
    }

    @ApiOperation("添加用户")
    @Action(description = "添加用户")
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
            userService.createUser(user);
            redisUtil.del(mail);
            return CommonResult.success("添加用户成功,昵称为：" + user.getUser_nickname());
        }
        return CommonResult.validateFailed("邮箱验证失败");

    }

    @ApiOperation("修改用户信息")
    @Action(description = "修改用户信息")
    @PostMapping("/updateUserInfo")
    public CommonResult updateUserByUserName(@Validated @RequestBody User user, BindingResult result) {

        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        user.setUser_updatetime(TimeUtils.getNowTime());
        userService.updateUserByUserName(user);
        return CommonResult.success("修改成功");
    }

    @ApiOperation("修改密码")
    @Action(description = "修改密码")
    @PostMapping("/updatePassword")
    public CommonResult updatePassword(@ApiParam("输入用户名、原密码和新密码") @RequestBody User user) {
        user.setUser_updatetime(TimeUtils.getNowTime());
        Boolean flag = userService.verifyPassword(user);
        if (flag) {
            user.setUser_password(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()));
            userService.updateUserByUserName(user);
            return CommonResult.success("修改密码成功！");
        }
        return CommonResult.validateFailed("原密码不正确！");
    }

    @ApiOperation("忘记密码")
    @Action(description = "忘记密码")
    @PostMapping("/forgetPassword")
    public CommonResult forgetPassword(@Validated @RequestBody ForgetPasswordVo user, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        if (user.getMail_code().equals(redisUtil.get(user.getUser_mail()))) {
            user.setUser_updatetime(TimeUtils.getNowTime());
            user.setUser_password(DigestUtils.md5DigestAsHex(user.getUser_password().getBytes()));

            userService.forgetPassword(user);
            return CommonResult.success("修改密码成功");
        }

        return CommonResult.validateFailed("修改密码失败，请输入正确的验证码");

    }

    @ApiOperation("用户报名志愿者")
    @Action(description = "用户报名志愿者")
    @PostMapping("userApplication")
    public CommonResult userApplication(@Validated @RequestBody UserApplicationVo userApplicationVo,BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        Bases bases = basesService.queryBasesById(userApplicationVo.getB_id());
        userApplicationVo.setB_joinPopulation(bases.getB_joinPopulation());
        userApplicationVo.setB_population(bases.getB_population());
        userApplicationVo.setB_status(bases.getB_status());

        if (userService.userApplication(userApplicationVo)) {
            return CommonResult.success("报名成功！");
        }
        return CommonResult.validateFailed("报名失败,当前报名基地报名人数已满或不开启报名");
    }

    @ApiOperation("发送邮箱验证码")
    @Action(description = "发送邮箱验证码")
    @PostMapping("/verifyMail")
    public CommonResult verifyMail(@Validated @RequestBody VerifyMailVo user, BindingResult result) {

        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        setMail.sendMail(user.getUser_mail());
        return CommonResult.success("邮箱发送成功");
    }

}
