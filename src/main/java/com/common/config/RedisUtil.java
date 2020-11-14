package com.common.config;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.concurrent.TimeUnit;

@Configuration
public class RedisUtil {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void set(String key,String val,long time){
        redisTemplate.opsForValue().set(key,val,time, TimeUnit.SECONDS);
    }

    public String get(String key){

        return redisTemplate.opsForValue().get(key);
    }

    public Long exists(String key){
        return redisTemplate.getExpire(key);
    }
}
