package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.pojo.vo.PetNameVo;
import com.service.PetsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@RestController
@Api(tags = "后台宠物接口")
public class PetsManageController {

    @Autowired
    private PetsService service;

    @ApiOperation("根据宠物名查询宠物信息")
    @Action(description = "根据宠物名查询宠物信息")
    @PostMapping("queryPetByName")
    public CommonResult queryPetsInfoByBaseId(@RequestBody PetNameVo pi_name) {
        return CommonResult.success(service.queryPetByName(pi_name.getPetName()));
    }

    @ApiOperation("查询所有宠物申请表单")
    @Action(description = "查询所有宠物申请表单")
    @GetMapping("queryPetByName")
    public CommonResult queryAdoptionForm(){
        return CommonResult.success(service.queryAdoptionForm());
    }
}
