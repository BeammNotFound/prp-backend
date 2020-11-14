package com.controller;


import com.common.api.CommonResult;
import com.common.api.TimeUtils;
import com.pojo.Popularizations;
import com.service.PopularizationsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "科普接口")
public class PopularizationsController {

    @Autowired
    PopularizationsService service;

    @ApiOperation("查询科普列表")
    @PostMapping("/queryPopularizationsList")
    public CommonResult queryPopularizations(@ApiParam("输入科普类型") @RequestBody Popularizations popularizations) {
        return CommonResult.success(service.queryPopularizations(popularizations));
    }

    @ApiOperation("创建科普信息")
    @PostMapping("/createPopularization")
    public CommonResult createPopularization(@ApiParam("输入科普内容") @RequestBody Popularizations popularizations) {

        popularizations.setP_createtime(TimeUtils.getNowTime());
        popularizations.setP_updatetime(TimeUtils.getNowTime());
        popularizations.setP_pv(1);

        service.createPopularization(popularizations);
        return CommonResult.success("创建成功，标题为：" + popularizations.getP_title());

    }

    @ApiOperation("通过标题或者文章内容模糊查询科普内容")
    @PostMapping("/fuzzyQueryPopularizations")
    public CommonResult fuzzyQueryPopularizations(@ApiParam("输入要查询的标题或者资讯内容") @RequestBody Popularizations popularizations) {

        List<Popularizations> list = service.fuzzyQueryPopularizations(popularizations);

        if (null == list || list.size() == 0) {
            return CommonResult.success("查不到内容呢 QAQ ,检查一下搜索内容~");
        }
        return CommonResult.success(list);

    }
}
