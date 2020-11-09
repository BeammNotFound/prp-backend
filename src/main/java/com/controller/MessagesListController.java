package com.controller;

import com.common.api.CommonResult;
import com.common.api.TimeUtils;
import com.pojo.Messages;
import com.service.MessagesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesListController {

    @Autowired
    MessagesListService messagesListService;

    @GetMapping("/allMessages")
    public CommonResult allMessages(){
        try {
            return CommonResult.success(messagesListService.allMessages());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("服务器错误");
        }
    }

    @RequestMapping("/createMessage")
    public CommonResult createMessage(@RequestBody Messages messages) {
        messages.setCreate_time(TimeUtils.getNowTime());
        messages.setUpdate_time(TimeUtils.getNowTime());
        try {
            messagesListService.createMessage(messages);
            return CommonResult.success("添加资讯成功！资讯标题为："+messages.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("服务器错误");
        }

    }
}
