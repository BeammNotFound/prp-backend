package com.controller;

import com.common.api.CommonResult;
import com.common.tools.TimeUtils;
import com.pojo.Messages;
import com.service.MessagesListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "资讯列表接口")
public class MessagesListController {

    @Autowired
    MessagesListService messagesListService;

    @ApiOperation("获取全部资讯列表")
    @GetMapping("/queryMessages")
    public CommonResult allMessages(){

        return CommonResult.success(messagesListService.allMessages());
    }

    @ApiOperation("创建资讯")
    @PostMapping("/createMessage")
    public CommonResult createMessage(@ApiParam("输入资讯") @RequestBody Messages messages){
        messages.setM_createtime(TimeUtils.getNowTime());
        messages.setM_updatetime(TimeUtils.getNowTime());
        messages.setM_pv(1);
        messagesListService.createMessage(messages);
        return CommonResult.success("添加资讯成功！资讯标题为：" + messages.getM_title());
    }

    @ApiOperation("通过标题或者文章内容模糊查询资讯")
    @PostMapping("fuzzyQueryMessages")
    public CommonResult fuzzyQueryMessages(@ApiParam("输入要查询的标题或者资讯内容") @RequestBody Messages messages) {
        List<Messages> list = messagesListService.fuzzyQueryMessages(messages);
        if (null == list || list.size() == 0) {
            return CommonResult.success("查不到内容呢 QAQ ,检查一下搜索内容~");
        }
        return CommonResult.success(list);
    }
}
