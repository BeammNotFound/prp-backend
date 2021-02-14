package com.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//配置Swagger
@Configuration
@EnableSwagger2
public class MySwaggerConfig {
    //api接口包扫描路径
    public static final String ReceptionController = "com.controller.RController";
    public static final String ManagementController = "com.controller.MController";
//    public static final String VERSION = "1.0.0";
    @Bean("前台")
    public Docket ReceptionController() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("前台")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(ReceptionController))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    @Bean("后台")
    public Docket ManagementController() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("后台")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(ManagementController))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("宠物救助平台") //设置文档的标题
                .description("宠物救助平台 API 接口文档") // 设置文档的描述
//                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
                .termsOfServiceUrl("") // 设置文档的License信息->1.3 License information
                .build();
    }
}
