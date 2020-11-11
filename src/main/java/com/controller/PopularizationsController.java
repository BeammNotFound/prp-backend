package com.controller;


import com.common.api.CommonResult;
import com.common.api.TimeUtils;
import com.pojo.Popularizations;
import com.service.PopularizationsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "科普接口")
public class PopularizationsController {

    @Autowired
    PopularizationsService service;

    @ApiOperation("查询科普列表")
    @GetMapping("/queryPopularizationsList")
    public CommonResult queryPopularizations(){
        return CommonResult.success(service.queryPopularizations());
    }

    @ApiOperation("创建科普信息")
    @PostMapping("/createPopularization")
    public CommonResult createPopularization(@ApiParam("输入科普内容")@RequestBody Popularizations popularizations){

        popularizations.setP_createtime(TimeUtils.getNowTime());
        popularizations.setP_updatetime(TimeUtils.getNowTime());
        popularizations.setP_pv(1);

        service.createPopularization(popularizations);
        return CommonResult.success("创建成功，标题为："+popularizations.getP_title());

    }
}
