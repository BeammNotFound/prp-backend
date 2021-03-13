package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.pojo.vo.BaseIdVo;
import com.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */

@Api(tags = "后台留言接口")
@RestController
public class ContactManageController {

    @Autowired
    private ContactService service;

    @ApiOperation("根据base_id查询留言信息")
    @Action(description = "根据base_id查询留言信息")
    @PostMapping("queryContactByBaseId")
    public CommonResult queryContactByBaseId(@RequestBody BaseIdVo vo){
        return CommonResult.success(service.queryContactByBaseId(vo));
    }
}
