package com.common.config;

import com.common.api.Action;
import com.common.utils.TimeUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @auther: gaopeng
 */
@Aspect
@Component
public class MyAspect {

    /**
     * 切入点
     */
    // 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
    //@Pointcut("execution(public * com.gaopeng.springboot.mytest.controller.*.*(..))")
    @Pointcut("@annotation(com.common.api.Action)")
    public void execute(){
    }

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before(value ="execute()")
    public void Before(JoinPoint joinPoint) {
//        System.out.println("执行方法之前");
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value ="execute()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
//        System.out.println("环绕通知开始");
        try {
            System.out.println(TimeUtils.getNowTime()+  "  执行方法:   " + proceedingJoinPoint.getSignature().getName());

//            MethodSignature signature =(MethodSignature) proceedingJoinPoint.getSignature();
//            Action action = signature.getMethod().getAnnotation(Action.class);
//
//            System.out.println("菜单="+action.description());

            Object object =  proceedingJoinPoint.proceed();
//            System.out.println("环绕通知结束，方法返回:" + object);
            return object;
        } catch (Throwable e) {
            System.out.println("执行方法异常:" + e.getClass().getName());
            return null;
        }
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    @After(value ="execute()")
    public void After(JoinPoint joinPoint) {
//        System.out.println("执行方法之后");
    }

    /**
     * 后置通知，带返回值
     * @param obj
     */
    @AfterReturning(pointcut = "execute()",returning = "obj")
    public void AfterReturning(Object obj) {
//        System.out.println("执行方法之后获取返回值："+obj);
    }

    /**
     * 后置通知，异常时执行
     * @param e
     */
    @AfterThrowing(throwing = "e",pointcut = "execute()")
    public void doAfterThrowing(Exception e) {
        System.out.println("执行方法异常："+e.getClass().getName());
    }
}