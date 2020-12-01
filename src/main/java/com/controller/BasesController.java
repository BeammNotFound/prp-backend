package com.controller;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.pojo.Bases;
import com.pojo.vo.BaseIdVo;
import com.pojo.vo.QueryBasesVo;
import com.service.BasesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "基地接口")
@RestController
public class BasesController {

    @Autowired
    private BasesService service;

    @ApiOperation("查询基地信息")
    @Action(description = "查询基地信息")
    @GetMapping("/queryBases")
    public CommonResult queryBases() {
        return CommonResult.success(service.queryBases());
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
    public CommonResult delBases(@Validated @RequestBody BaseIdVo baseIdVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        service.delBases(baseIdVo);
        return CommonResult.success("删除成功");
    }

    @ApiOperation("根据基地id查询领养宠物")
    @Action(description = "根据基地id查询领养宠物")
    @PostMapping("queryAPList")
    public CommonResult queryAPList(@Validated @RequestBody BaseIdVo baseIdVo,BindingResult result) {

        if (result.hasErrors()) {
            CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        return CommonResult.success(service.queryAPList(baseIdVo));

    }


    @ApiOperation("根据基地id查询基地图片")
    @Action(description = "根据基地id查询基地图片")
    @PostMapping("queryBasesImagesById")
    public CommonResult queryBasesImagesById(@Validated @RequestBody BaseIdVo baseIdVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }

        return CommonResult.success(service.queryBasesImagesById(baseIdVo));

    }

    @ApiOperation("根据基地id查询基地动态")
    @Action(description = "根据基地id查询基地动态")
    @PostMapping("queryBaseMessagesById")
    public CommonResult queryBaseMessagesById(@Validated @RequestBody BaseIdVo baseIdVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }

        return CommonResult.success(service.queryBaseMessages(baseIdVo));
    }
}
