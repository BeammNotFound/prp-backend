package com.common.tools;

import com.common.config.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Random;

@Configuration
public class SetMail {


    private RedisUtil redisUtil;

    private JavaMailSender javaMailSender;

    public SetMail(JavaMailSender javaMailSender, RedisUtil redisUtil) {
        this.javaMailSender = javaMailSender;
        this.redisUtil = redisUtil;
    }

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public String sendMail(String mail){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            redisUtil.set(mail,checkCode,5*60);
            message.setFrom("742919609@qq.com");
            message.setTo(mail);
            message.setSubject("欢迎成为宠物救助平台的用户");
            message.setText("您的注册验证码为：" + checkCode);

            javaMailSender.send(message);
            logger.info("邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return checkCode;

    }
}
