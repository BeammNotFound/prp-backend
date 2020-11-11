package com.common.config;

import com.common.api.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//自定义抛出异常
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value =Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public CommonResult exceptionHandler(Exception e){
        e.printStackTrace();
		return CommonResult.failed("服务器错误");
    }
}