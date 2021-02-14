package com.controller.RController;


import com.common.api.Action;
import com.common.api.CommonResult;
import com.pojo.Popularizations;
import com.service.PopularizationsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "科普接口")
public class PopularizationsController {

    @Autowired
    private PopularizationsService service;

    @ApiOperation("查询科普列表")
    @Action(description = "查询科普列表")
    @PostMapping("/queryPopularizationsList")
    public CommonResult queryPopularizations(@RequestBody Popularizations popularizations) {
        return CommonResult.success(service.queryPopularizations(popularizations));

    }
}
