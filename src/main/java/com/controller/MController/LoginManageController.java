package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.pojo.Bases;
import com.pojo.vo.LoginVo;
import com.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@RestController
@Api(tags = "后台登录接口")
public class LoginManageController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("后台登录")
    @Action(description = "后台登录")
    @PostMapping("loginInManage")
    public CommonResult loginInManage(@Validated @RequestBody LoginVo vo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        Bases bases = loginService.loginInManage(vo);
        if (bases.getBase_id() == 0) {
            return CommonResult.validateFailed("登录失败，请检查用户名密码");
        }
        return CommonResult.success(bases);
    }

}
