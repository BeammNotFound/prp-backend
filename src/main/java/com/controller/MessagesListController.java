package com.controller;

import com.common.api.CommonResult;
import com.common.api.TimeUtils;
import com.pojo.Messages;
import com.service.MessagesListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "资讯列表接口")
public class MessagesListController {

    @Autowired
    MessagesListService messagesListService;

    @ApiOperation("获取全部资讯接口")
    @GetMapping("/allMessages")
    public CommonResult allMessages(){
        try {
            return CommonResult.success(messagesListService.allMessages());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("服务器错误");
        }
    }

    @PostMapping("/createMessage")
    public CommonResult createMessage(@RequestBody Messages messages) {
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
}
