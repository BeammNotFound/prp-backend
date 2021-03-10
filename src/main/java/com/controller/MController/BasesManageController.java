package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.pojo.BaseMessages;
import com.pojo.Bases;
import com.pojo.vo.BaseIdVo;
import com.pojo.vo.QueryBasesVo;
import com.service.BasesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Api(tags = "后台基地接口")
@RestController
public class BasesManageController {

    @Autowired
    private BasesService service;

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

    @ApiOperation("根据bm_id修改基地资讯成功")
    @Action(description = "根据bm_id修改基地资讯成功")
    @PostMapping("changeBasesMessagesById")
    public CommonResult changeBasesMessagesById(@RequestBody BaseMessages po) {
        service.changeBasesMessagesById(po);
        return CommonResult.success("修改基地资讯成功！");
    }

    @ApiOperation("插入基地咨询")
    @Action(description = "插入基地咨询")
    @PostMapping("insertBasesMessage")
    public CommonResult insertBasesMessage(@RequestBody BaseMessages po) {
        service.insertBasesMessage(po);
        return CommonResult.success("插入基地咨询成功！资讯标题为：" + po.getBm_title());
    }

}
