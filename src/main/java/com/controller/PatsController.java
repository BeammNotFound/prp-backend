package com.controller;


import com.common.api.Action;
import com.common.api.CommonResult;
import com.pojo.vo.BaseIdVo;
import com.service.PetsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "宠物接口")
@RestController
public class PatsController {

    @Autowired
    private PetsService petsService;

    @ApiOperation("根据基地id查询领养宠物")
    @Action(description = "根据基地id查询领养宠物")
    @PostMapping("queryAPList")
    public CommonResult queryPetsInfoByBaseId(@Validated @RequestBody BaseIdVo baseIdVo, BindingResult result) {

        if (result.hasErrors()) {
            CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        return CommonResult.success(petsService.queryPetsInfoByBaseId(baseIdVo.getBase_id()));

    }
}
