package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.TimeUtils;
import com.pojo.vo.ApplicationVo;
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
}
