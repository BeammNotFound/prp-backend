package com.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Random;

@Configuration
public class SetMail {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private JavaMailSender javaMailSender;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public String sendMail(String mail){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            redisUtil.set(mail, checkCode, 30);
            message.setFrom("742919609@qq.com");
            message.setTo(mail);
            message.setSubject("欢迎成为宠物救助平台的用户");
            message.setText("您的注册验证码为：" + checkCode);

            javaMailSender.send(message);
            logger.info("邮件发送成功");
        } catch (MailSendException e) {
            logger.error("目标邮箱不存在");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文本邮件发送异常");
        }
        return checkCode;

    }
}
