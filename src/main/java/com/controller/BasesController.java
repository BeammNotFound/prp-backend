package com.controller;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.RedisUtil;
import com.pojo.vo.QueryBasesVo;
import com.service.BasesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
            redisUtil.set("allBases", service.queryBases(),30);
        }
        return CommonResult.success(redisUtil.get("allBases"));
    }

    @ApiOperation("根据基地名模糊搜索基地信息")
    @Action(description = "根据基地名模糊搜索基地信息")
    @PostMapping("fuzzyQueryBases")
    public CommonResult fuzzyQueryBases(@Validated @RequestBody QueryBasesVo basesVo, BindingResult result){
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        return CommonResult.success(service.fuzzyQueryBases(basesVo));

    }
}
