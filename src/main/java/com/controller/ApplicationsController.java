package com.controller;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.TimeUtils;
import com.pojo.Bases;
import com.pojo.vo.QueryUserApplication;
import com.pojo.vo.UserApplicationVo;
import com.pojo.vo.UserIdVo;
import com.service.ApplicationsService;
import com.service.BasesService;
import com.service.UserService;
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
@Api(tags = "志愿者/宠物领养 接口")
@RestController
public class ApplicationsController {

    @Autowired
    private ApplicationsService applicationsService;

    @Autowired
    private UserService userService;

    @Autowired
    private BasesService basesService;


    @ApiOperation("用户报名志愿者")
    @Action(description = "用户报名志愿者")
    @PostMapping("userApplication")
    public CommonResult userApplication(@Validated @RequestBody UserApplicationVo userApplicationVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());

        }

        if (userService.queryUserByName(userApplicationVo.getUser_name()).getUser_application() != null) {
            return CommonResult.validateFailed("您已经报过名啦");
        }

        Bases bases = basesService.queryBasesById(userApplicationVo.getBase_id());
        userApplicationVo.setB_joinPopulation(bases.getB_joinPopulation());
        userApplicationVo.setB_population(bases.getB_population());
        userApplicationVo.setB_status(bases.getB_status());

        if((bases.getB_endtime()).before(TimeUtils.getNowTime())) {
            return CommonResult.validateFailed("活动已截止");
        }else if(applicationsService.userApplication(userApplicationVo)) {
            return CommonResult.success("报名成功！");
        }

        return CommonResult.validateFailed("报名失败,当前报名基地报名人数已满或不开启报名");
    }

    @ApiOperation("查询用户报名志愿者接口")
    @Action(description = "根据用户id查询用户报名志愿者接口")
    @PostMapping("queryUserApplication")
    public CommonResult queryUserApplication(@Validated @RequestBody UserIdVo userIdVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        QueryUserApplication application = applicationsService.queryUserApplication(userIdVo.getUser_id());
        if (application == null) {
            return CommonResult.validateFailed("你没有参加任何志愿者活动呢");
        }
        return CommonResult.success(application);
    }


}
