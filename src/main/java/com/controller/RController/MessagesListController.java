package com.controller.RController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.service.MessagesListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
//@Api(tags = "资讯列表接口")
public class MessagesListController {

    @Autowired
    private MessagesListService messagesListService;

    @ApiOperation("获取全部资讯列表")
    @Action(description = "获取全部资讯列表")
    @GetMapping("/queryMessages")
    public CommonResult allMessages() {
        return CommonResult.success(messagesListService.allMessages());
    }

}
