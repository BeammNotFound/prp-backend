package com.common.api;

import java.lang.annotation.*;


//自定义日志审计注释
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Action {
    String description() default "no description";
}