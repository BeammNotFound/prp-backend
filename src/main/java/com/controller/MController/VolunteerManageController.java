package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.service.VolunteerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@RestController
@Api(tags = "后台志愿者接口")
public class VolunteerManageController {

    @Autowired
    private VolunteerService volunteerService;

    @ApiOperation("查询所有志愿者表单")
    @Action(description = "查询所有志愿者表单")
    @GetMapping("queryVolunteerFrom")
    public CommonResult queryVolunteerFrom() {
        return CommonResult.success(volunteerService.queryVolunteerFrom());
    }
}
