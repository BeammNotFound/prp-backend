package com.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("留言实体类")
public class Contact {
    private Integer c_id;
    private Integer user_id,user_age;
    private String user_realname,c_words,user_icon,user_mail,user_sex,user_address;
    private Integer base_id;
    private Date c_createtime;
}
