package com.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginHandlerInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(                         //添加不拦截路径
                "/login",
                "/queryMessages",
                "/creatUser",
                "/verifyMail",
                "/forgetPassword",
                "/queryPopularizationsList",
                "/fuzzyQueryMessages",
                "/fuzzyQueryMessages",
                "/createMessage",
                "/createPopularization",
                "/",
                "/csrf",
                "/favicon.ico",



                "/**/*.html",            //html静态资源
                "/**/*.js",              //js静态资源
                "/**/*.css",             //css静态资源
                "/**/*.woff",
                "/**/*.ttf"
        );
    }

    //配置不拦截swagger
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}