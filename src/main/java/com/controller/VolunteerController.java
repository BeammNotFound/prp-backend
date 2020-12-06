package com.controller;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.pojo.ApplicationVolunteer;
import com.pojo.VolunteerFrom;
import com.pojo.vo.QueryVolunteerByIdVo;
import com.pojo.vo.UserIdVo;
import com.service.VolunteerService;
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
@Api(tags = "志愿者接口")
@RestController
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @ApiOperation("用户报名志愿者")
    @Action(description = "用户报名志愿者")
    @PostMapping("userApplication")
    public CommonResult userApplication(@Validated @RequestBody ApplicationVolunteer volunteer, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }

        Integer flag = volunteerService.userApplication(volunteer);

        if(flag == 2) {
            return CommonResult.validateFailed("报名失败,当前报名基地志愿者报名人数已满");
        }else if(flag == 3) {
            return CommonResult.validateFailed("报名失败，志愿者报名已截止");
        } else if (flag == 4) {
            return CommonResult.validateFailed("报名失败，志愿者报名未开始");
        } else if (flag == 5) {
            return CommonResult.validateFailed("报名失败,当前报名基地未开启志愿者报名");
        } else if (flag == 6) {
            return CommonResult.validateFailed("您已经报过名啦");
        }

        return CommonResult.success("报名成功！");

    }

    @ApiOperation("查询用户报名志愿者接口")
    @Action(description = "根据用户id查询用户报名志愿者接口")
    @PostMapping("queryUserApplication")
    public CommonResult queryUserApplication(@Validated @RequestBody UserIdVo userIdVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        QueryVolunteerByIdVo application = volunteerService.queryAppVolunteerById(userIdVo.getUser_id());
        if (application == null) {
            return CommonResult.validateFailed("你没有参加任何志愿者活动呢");
        }
        return CommonResult.success(application);
    }

    @ApiOperation("创建志愿者申请表单")
    @Action(description = "创建志愿者申请表单")
    @PostMapping("createVolunteerForm")
    public CommonResult createVF(@Validated @RequestBody VolunteerFrom vo,BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        volunteerService.createVF(vo);
        return CommonResult.success("创建志愿者申请表单成功");
    }

}
