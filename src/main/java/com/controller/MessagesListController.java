package com.controller;

import com.common.api.CommonResult;
import com.common.api.TimeUtils;
import com.pojo.Messages;
import com.service.MessagesListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "资讯列表接口")
public class MessagesListController {

    @Autowired
    MessagesListService messagesListService;

    @ApiOperation("获取全部资讯")
    @GetMapping("/allMessages")
    public CommonResult allMessages(){
        try {
            return CommonResult.success(messagesListService.allMessages());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("服务器错误");
        }
    }

    @ApiOperation("创建资讯")
    @PostMapping("/createMessage")
    public CommonResult createMessage(@ApiParam("输入资讯") @RequestBody Messages messages){
        messages.setCreate_time(TimeUtils.getNowTime());
        messages.setUpdate_time(TimeUtils.getNowTime());
        try {
            messagesListService.createMessage(messages);
            return CommonResult.success("添加资讯成功！资讯标题为：" + messages.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("服务器错误");
        }

    }

    @ApiOperation("通过标题或者文章内容模糊查询资讯")
    @PostMapping("fuzzyQueryMessages")
    public CommonResult fuzzyQueryMessages(@ApiParam("输入要查询的标题或者资讯内容") @RequestBody Messages messages) {
        try {
            return CommonResult.success(messagesListService.fuzzyQueryMessages(messages));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("服务器错误");
        }
    }
}
