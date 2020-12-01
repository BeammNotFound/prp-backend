package com.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryUserApplication {
    @NotBlank(message = "用户id不能为空")
    private Integer user_id;

    private String user_realname;
    private Integer user_application;
    private String user_phone;


    private String b_icon;
    private String b_id;
    private String b_name;
    private Date b_createtime;
    private Date b_endtime;
    private String b_mail;
    private String b_address;
    private String b_phone;
    private String b_contacts;
    private String b_intro;

}
