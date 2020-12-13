package com.controller;


import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.SetMail;
import com.common.utils.TimeUtils;
import com.common.utils.UpLoadImages;
import com.pojo.User;
import com.pojo.vo.*;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags = "用户接口")
@RestController
public class UserController {

    @Autowired
    private SetMail setMail;

    @Autowired
    private UserService userService;


    @ApiOperation("查询全部用户信息")
    @Action(description = "查询全部用户信息")
    @GetMapping("/queryUserList")
    public CommonResult queryUserList() {

        return CommonResult.success(userService.queryUserList());
    }

    @ApiOperation("新增用户")
    @Action(description = "新增用户")
    @PostMapping("/creatUser")
    public CommonResult createUser(@ApiParam("输入用户数据") @Validated @RequestBody CreateUserVo user, BindingResult result) {

//        判断是否为空
        if (result.hasErrors()) {
           return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }

        if (userService.createUser(user)) {
            return CommonResult.success("添加用户成功,昵称为：" + user.getUser_nickname());
        }
        return CommonResult.validateFailed("邮箱验证失败");

    }

    @ApiOperation("修改用户信息")
    @Action(description = "修改用户信息")
    @PostMapping("/updateUserInfo")
    public CommonResult updateUserByUserName(@Validated @RequestBody UpdateUserInfoVo vo, BindingResult result) {

        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }

        vo.setUser_updatetime(TimeUtils.getNowTime());
        userService.updateUserByUserId(vo);
        return CommonResult.success("修改成功");
    }

    @ApiOperation("根据用户名修改密码")
    @Action(description = "根据用户名修改密码")
    @PostMapping("/updatePasswordByUserName")
    public CommonResult updatePassword(@Validated @RequestBody UpdatePasswordVo updatePasswordVo,BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        if (userService.verifyPassword(updatePasswordVo)) {
            if (updatePasswordVo.getEnter_password().equals(updatePasswordVo.getUser_password())) {
                return CommonResult.validateFailed("原密码和新密码不能相同");
            }
            updatePasswordVo.setUser_password(DigestUtils.md5DigestAsHex(updatePasswordVo.getUser_password().getBytes()));
            updatePasswordVo.setUser_updatetime(TimeUtils.getNowTime());
            userService.updatePasswordByUserName(updatePasswordVo);
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
        if (userService.forgetPassword(user)) {
            return CommonResult.success("修改密码成功");
        }
        return CommonResult.validateFailed("修改密码失败，请输入正确的验证码");

    }

    @ApiOperation("发送邮箱验证码")
    @Action(description = "发送邮箱验证码")
    @PostMapping("/verifyMail")
    public CommonResult verifyMail(@Validated @RequestBody VerifyMailVo user, BindingResult result) {

        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }

        User u = userService.queryUserByName(user.getUser_mail());
        if (u != null) {
            if (u.getUser_mail().equals(user.getUser_mail()))
                return CommonResult.validateFailed("您已经注册过了，请直接登陆");
        }

        setMail.sendMail(user.getUser_mail());
        return CommonResult.success("邮箱发送成功");
    }

    @ApiOperation("根据id修改用户头像")
    @Action(description = "根据id修改用户头像")
    @PostMapping("changeUserIconById")
    public CommonResult changeUserIconById(Integer user_id, MultipartFile icon_file){
        UpdateUserInfoVo vo = new UpdateUserInfoVo();
        if (icon_file != null) {
            try {
                vo.setUser_icon(new UpLoadImages().uploadImage(icon_file));
            } catch (IOException e) {
                CommonResult.validateFailed("头像上传失败");
                e.printStackTrace();
            }
        }
        vo.setUser_updatetime(TimeUtils.getNowTime());
        vo.setUser_id(user_id);
        userService.updateUserByUserId(vo);
        return CommonResult.success(vo.getUser_icon());
    }
}
