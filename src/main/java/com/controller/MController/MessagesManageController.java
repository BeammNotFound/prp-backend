package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.TimeUtils;
import com.pojo.Messages;
import com.service.MessagesListService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
//@RestController
//@Api(tags = "后台资讯列表接口")
public class MessagesManageController {
    @Autowired
    private MessagesListService messagesListService;

//    @ApiOperation("获取全部资讯列表")
//    @Action(description = "获取全部资讯列表")
//    @GetMapping("/queryManageMessages")
//    public CommonResult allManageMessages() {
//        return CommonResult.success(messagesListService.allMessages());
//}

    @ApiOperation("创建资讯")
    @Action(description = "创建资讯")
    @PostMapping("/createMessage")
    public CommonResult createMessage(@Validated @RequestBody Messages messages, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        messages.setM_createtime(TimeUtils.getNowTime());
        messages.setM_updatetime(TimeUtils.getNowTime());
        messages.setM_pv(1);
        messagesListService.createMessage(messages);

        return CommonResult.success("添加资讯成功！资讯标题为：" + messages.getM_title());
    }

    @ApiOperation("通过标题或者文章内容模糊查询资讯")
    @Action(description = "通过标题或者文章内容模糊查询资讯")
    @PostMapping("fuzzyQueryMessages")
    public CommonResult fuzzyQueryMessages(@ApiParam("输入要查询的标题或者资讯内容") @RequestBody Messages messages) {
        List<Messages> list = messagesListService.fuzzyQueryMessages(messages);
        if (null == list || list.size() == 0) {
            return CommonResult.success("查不到内容呢 QAQ ,检查一下搜索内容~");
        }
        return CommonResult.success(list);
    }

    @ApiOperation("删除资讯")
    @Action(description = "删除资讯")
    @PostMapping("deleteMessageById")
    public CommonResult deleteMessageById(@RequestBody Messages messages) {

        Integer id = messages.getM_id();

        if ("null".equals(id) || "0".equals(id) || id <= 0) {

            return CommonResult.validateFailed("请输入资讯id");
        }
        messagesListService.deleteMessageById(messages);
        return CommonResult.success("删除成功，删除标题为：" + messages.getM_title());
    }
}
