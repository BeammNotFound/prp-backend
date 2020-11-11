package com.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource DruidDataSource(){
        return new DruidDataSource();
    }

    //后台监控功能:web.xml
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台登录（账号密码配置）
        HashMap<String, String> hashMap = new HashMap<>();

        //增加配置
        //登录的key是固定的(loginUsername和loginPassword）
        hashMap.put("loginUsername", "admin");
        hashMap.put("loginPassword", "lianghao");

        //允许谁可以访问
        hashMap.put("allow", "localhost");
        //初始化参数
        bean.setInitParameters(hashMap);

        return bean;
    }

}
