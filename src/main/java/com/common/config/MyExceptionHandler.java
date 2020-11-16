package com.common.config;

import com.common.api.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.common.api.ResultCode.UNAUTHORIZED;
import static com.common.api.ResultCode.VALIDATE_FAILED;


//自定义抛出异常
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value =Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public CommonResult exceptionHandler(Exception e){
        e.printStackTrace();
		return CommonResult.failed("服务器错误");
    }
//    @ExceptionHandler(value =NullPointerException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public CommonResult exceptionHandler(NullPointerException e){
//        e.printStackTrace();
//        return CommonResult.success("用户名密码错误");
//    }

}