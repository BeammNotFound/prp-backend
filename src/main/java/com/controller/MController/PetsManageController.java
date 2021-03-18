package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.TimeUtils;
import com.pojo.PetsInfo;
import com.pojo.vo.*;
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

    @ApiOperation("根据user_id查询所有宠物申请表单")
    @Action(description = "根据user_id查询所有宠物申请表单")
    @PostMapping("queryAdoptionFormByUserId")
    public CommonResult queryAdoptionForm(@RequestBody UserIdVo vo){
        return CommonResult.success(service.queryAdoptionFormByUserId(vo));
    }

    @ApiOperation("根据ap_id修改宠物审批状态")
    @Action(description = "根据ap_id修改宠物审批状态")
    @PostMapping("updateApStatusByid")
    public CommonResult updateApStatusByid(@RequestBody ApStatusVo apStatusVo) {
        Integer status = apStatusVo.getStatus();
        if (status.equals(1)) {
            apStatusVo.setAp_status("审批通过");
            service.updateApStatusByid(apStatusVo);
            apStatusVo.setAp_pass_time(TimeUtils.getNowTime());
            service.updateApPassTimeByid(apStatusVo);
            return CommonResult.success("审批通过成功！");
        } else if (status.equals(3)) {
            apStatusVo.setAp_status("审批驳回");
            service.updateApStatusByid(apStatusVo);
            return CommonResult.success("审批驳回成功！");
        }
        return CommonResult.validateFailed("审批失败，请重试！");
    }

    @ApiOperation("根据ap_status筛选领养宠物表单信息")
    @Action(description = "根据ap_status筛选领养宠物表单信息")
    @PostMapping("queryApFormByStatus")
    public CommonResult queryApFormByStatus(@RequestBody ApStatusVo vo){

        Integer status = vo.getStatus();
        if (status.equals(1)) {
            vo.setAp_status("审批通过");
        }else if(status.equals(2)){
            vo.setAp_status("待审批");
        } else if (status.equals(3)) {
            vo.setAp_status("审批驳回");
        }
        return CommonResult.success(service.queryApFormByStatus(vo));
    }

    @ApiOperation("已被领养宠物接口")
    @Action(description = "已被领养宠物接口")
    @GetMapping("queryAdoptedPetsInfo")
    public CommonResult queryAdoptedPetsInfo() {
        return CommonResult.success(service.queryAdoptedPetsInfo());
    }

    @ApiOperation("未被领养宠物接口")
    @Action(description = "未被领养宠物接口")
    @GetMapping("queryUnAdoptedPetsInfo")
    public CommonResult queryUnAdoptedPetsInfo(){
        return CommonResult.success(service.queryUnAdoptedPetsInfo());
    }

    @ApiOperation("新增宠物接口")
    @Action(description = "新增宠物接口")
    @PostMapping("insertPetInfo")
    public CommonResult insertPetInfo(@Validated @RequestBody PetsInfo po, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        service.insertPetInfo(po);
        return CommonResult.success("增加宠物成功！宠物名为：" + po.getPi_name());
    }

    @ApiOperation("根据宠物id删除宠物接口")
    @Action(description = "根据宠物id删除宠物接口")
    @PostMapping("delPetByid")
    public CommonResult delPetByid(@RequestBody PetIdVo vo) {
        Integer pi_id = vo.getPi_id();
        if (pi_id.equals(null) || pi_id.equals(0)) {
            return CommonResult.validateFailed("宠物id不能为空或0");
        }
        service.delPetByid(vo);
        return CommonResult.success("删除宠物成功！宠物id为：" + pi_id);
    }

    @ApiOperation("通过pi_id更改宠物信息")
    @Action(description = "通过pi_id更改宠物信息")
    @PostMapping("changePetInfo")
    public CommonResult changePetInfo(@RequestBody PetInfoVo vo) {
        service.changePetInfo(vo);
        return CommonResult.success("更改宠物信息成功！被更改的宠物名为" + vo.getPi_name());
    }

    @ApiOperation("查询宠物喜欢")
    @Action(description = "查询宠物喜欢")
    @GetMapping("queryStarredPets")
    public CommonResult queryStarredPets(){
        return CommonResult.success(service.queryStarredPets());
    }
}
