package com.controller;


import com.common.api.Action;
import com.common.api.CommonResult;
import com.pojo.AdoptionPats;
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
public class PetsController {

    @Autowired
    private PetsService service;

    @ApiOperation("根据基地id查询领养宠物")
    @Action(description = "根据基地id查询领养宠物")
    @PostMapping("queryPetsInfoByBaseId")
    public CommonResult queryPetsInfoByBaseId(@Validated @RequestBody BaseIdVo baseIdVo, BindingResult result) {

        if (result.hasErrors()) {
            CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        return CommonResult.success(service.queryPetsInfoByBaseId(baseIdVo.getBase_id()));

    }

    @ApiOperation("申请领养宠物接口")
    @Action(description = "申请领养宠物接口")
    @PostMapping("adoptPet")
    public CommonResult adoptPet(@Validated @RequestBody AdoptionPats adoptionPats, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        if (service.adoptPet(adoptionPats)) {
            return CommonResult.success("申请领养成功");
        }
        return CommonResult.validateFailed("用户效验失败，请重新登录");
    }
}
