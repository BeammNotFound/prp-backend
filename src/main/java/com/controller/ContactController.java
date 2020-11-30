package com.controller;


import com.common.api.Action;
import com.common.api.CommonResult;
import com.pojo.Contact;
import com.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "留言接口")
@RestController
public class ContactController {

    @Autowired
    private ContactService service;

    @ApiOperation("创建留言")
    @Action(description = "创建留言")
    @PostMapping("CreateContact")
    public CommonResult CreateContact(@Validated @RequestBody Contact contact, BindingResult result){
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        service.createContact(contact);
        return CommonResult.success("创建成功");
    }
}
