package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.TimeUtils;
import com.pojo.vo.ApStatusVo;
import com.pojo.vo.PetNameVo;
import com.service.PetsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @ApiOperation("根据ap_id修改宠物审批状态")
    @Action(description = "根据ap_id修改宠物审批状态")
    @PostMapping("updateApStatusByid")
    public CommonResult updateApStatusByid(@Validated @RequestBody Integer status, ApStatusVo apStatusVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        if (status.equals(1)) {
            apStatusVo.setAp_status("审批通过");
            apStatusVo.setAp_pass_time(TimeUtils.getNowTime());
            service.updateApPassTimeByid(apStatusVo);
        } else if (status.equals(3)) {
            apStatusVo.setAp_status("审批驳回");
        }
        service.updateApStatusByid(apStatusVo);
        return CommonResult.success("修改成功");
    }
}
