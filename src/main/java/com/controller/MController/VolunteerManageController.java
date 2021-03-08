package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.TimeUtils;
import com.pojo.VolunteerInfo;
import com.pojo.vo.ApplicationVo;
import com.pojo.vo.AvStatusVo;
import com.pojo.vo.ViIdVo;
import com.pojo.vo.VolunteerInfoVo;
import com.service.VolunteerService;
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
@Api(tags = "后台志愿者接口")
public class VolunteerManageController {

    @Autowired
    private VolunteerService volunteerService;

    @ApiOperation("查询所有志愿者表单")
    @Action(description = "查询所有志愿者表单")
    @GetMapping("queryVolunteerFrom")
    public CommonResult queryVolunteerFrom() {
        return CommonResult.success(volunteerService.queryVolunteerFrom());
    }


    @ApiOperation("通过av_id修改志愿者审批状态")
    @Action(description = "通过av_id修改志愿者审批状态")
    @PostMapping("updateAVStatusByid")
    public CommonResult updateAVStatusByid(@RequestBody ApplicationVo vo) {
        Integer av_status = vo.getStatus();
        if (av_status == 1) {
            vo.setAv_status("审批通过");
            volunteerService.updateAVStatusByid(vo);
            vo.setAv_pass_time(TimeUtils.getNowTime());
            volunteerService.updateAVPassTimeByid(vo);
            return CommonResult.success("审批通过成功！");
        } else if (av_status == 3) {
            vo.setAv_status("审批驳回");
            volunteerService.updateAVStatusByid(vo);
            return CommonResult.success("审批驳回成功！");
        }
        return CommonResult.validateFailed("审批失败，请重试！");
    }

    @ApiOperation("根据av_status筛选志愿者申请表单信息")
    @Action(description = "根据av_status筛选志愿者申请表单信息")
    @PostMapping("queryAvFormByStatus")
    public CommonResult queryAvFormByStatus(@RequestBody AvStatusVo vo){
        Integer status = vo.getStatus();
        if (status.equals(1)) {
            vo.setAv_status("审批通过");
        }else if(status.equals(2)){
            vo.setAv_status("待审批");
        } else if (status.equals(3)) {
            vo.setAv_status("审批驳回");
        }
        return CommonResult.success(volunteerService.queryAvFormByStatus(vo));
    }

    @ApiOperation("根据vi_id修改志愿者表单数据")
    @Action(description = "根据vi_id修改志愿者表单数据")
    @PostMapping("changeVolunteerInfo")
    public CommonResult changeVolunteerInfo(@RequestBody VolunteerInfoVo vo) {
        Integer id = vo.getVi_id();
        if (id == 0 || id == null)
            return CommonResult.validateFailed("修改志愿者活动失败！请重试");

        volunteerService.changeVolunteerInfo(vo);
        return CommonResult.success("修改志愿者活动成功！志愿者活动id为：" + id);
    }

    @ApiOperation("新增志愿者活动")
    @Action(description = "新增志愿者活动")
    @PostMapping("createVolunteerInfo")
    public CommonResult createVolunteerInfo(@RequestBody VolunteerInfo po) {
        volunteerService.createVolunteerInfo(po);
        return CommonResult.success("增加志愿者活动成功!");
    }

    @ApiOperation("根据vi_id删除志愿者活动")
    @Action(description = "根据vi_id删除志愿者活动")
    @PostMapping("delVolunteerInfoByid")
    public CommonResult delVolunteerInfoByid(@RequestBody ViIdVo vo) {
        Integer id = vo.getVi_id();
        if (id == 0 || id == null)
            return CommonResult.validateFailed("删除志愿者活动失败，请重试");

        volunteerService.delVolunteerInfoByid(vo);
        return CommonResult.success("删除志愿者活动成功！志愿者活动id为" + id);
    }
}
