package com.controller;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.RedisUtil;
import com.pojo.Bases;
import com.pojo.vo.DelBasesVo;
import com.pojo.vo.QueryBasesVo;
import com.service.BasesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "基地接口")
@RestController
public class BasesController {

    @Autowired
    private BasesService service;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("查询基地信息")
    @Action(description = "查询基地信息")
    @GetMapping("/queryBases")
    public CommonResult queryBases() {

        //存入redis
        if (redisUtil.hasKey("allBases")) {
            return CommonResult.success(redisUtil.get("allBases"));
        } else {
            redisUtil.set("allBases", service.queryBases(), 30);
        }
        return CommonResult.success(redisUtil.get("allBases"));
    }

    @ApiOperation("根据基地名模糊搜索基地信息")
    @Action(description = "根据基地名模糊搜索基地信息")
    @PostMapping("fuzzyQueryBases")
    public CommonResult fuzzyQueryBases(@Validated @RequestBody QueryBasesVo basesVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }

        List<Bases> bases = service.fuzzyQueryBases(basesVo);
        if (bases == null || bases.size() == 0) {
            return CommonResult.validateFailed("查不到内容呢 QAQ ,检查一下搜索内容~");
        }
        return CommonResult.success(service.fuzzyQueryBases(basesVo));

    }

    @ApiOperation("删除基地")
    @Action(description = "删除基地")
    @PostMapping("delBases")
    public CommonResult delBases(@Validated @RequestBody DelBasesVo delBasesVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        service.delBases(delBasesVo);
        redisUtil.del("allBases");
        return CommonResult.success("删除成功");
    }

    @ApiOperation("根据基地id查询领养宠物")
    @Action(description = "根据基地id查询领养宠物")
    @PostMapping("queryAPList")
    public CommonResult queryAPList(@ApiParam("基地id") @RequestBody Integer ap_base) {

        if (ap_base == null) {
            return CommonResult.validateFailed("能不能告诉我你点了拿个基地？");
        }
        return CommonResult.success(service.queryAPList(ap_base));

    }


    @ApiOperation("根据基地id查询基地图片")
    @Action(description = "根据基地id查询基地图片")
    @PostMapping("queryBasesImagesById")
    public CommonResult queryBasesImagesById(@ApiParam("基地id") @RequestBody Integer bi_base){
        if (bi_base == null) {
            return CommonResult.validateFailed("能不能告诉我你点了拿个基地？");
        }
        return CommonResult.success(service.queryBasesImagesById(bi_base));

    }
}
