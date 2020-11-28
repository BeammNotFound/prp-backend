package com.controller;


import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.RedisUtil;
import com.pojo.Background;
import com.service.BackgroundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@Api(tags = "背景图片接口")
public class BackgroundController {

    @Autowired
    private BackgroundService service;

    @ApiOperation("随机获取一张背景图片")
    @Action(description = "随机获取一张背景图片")
    @GetMapping("getBackground")
    public CommonResult queryBackgroundById() {
        return CommonResult.success(service.queryImageById());
    }

    @ApiOperation("获取全部背景图片")
    @GetMapping("getAllBackground")
    @Action(description = "获取全部背景图片")
    public CommonResult getAllBackground() {
        return CommonResult.success(service.queryAllImages());
    }

}
