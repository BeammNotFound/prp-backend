package com.controller;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.RedisUtil;
import com.service.BasesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "基地接口")
@RestController
public class BasesController {

    @Autowired
    BasesService service;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RedisTemplate redisTemplate;

    @ApiOperation("查询基地信息")
    @Action(description = "查询基地信息")
    @GetMapping("/queryBases")
    public CommonResult queryBases(){

        //存入redis
        if (redisUtil.hasKey("allBases")) {
            return CommonResult.success(redisUtil.get("allBases"));
        }else {
            redisUtil.set("allBases", service.queryBases(),0);
        }
        return CommonResult.success(redisUtil.get("allBases"));
    }
}
