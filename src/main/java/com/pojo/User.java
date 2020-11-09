package com.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String user_name;
    private String user_nickname;
    private String user_realname;
    private String user_password;
    private Integer user_type;
    private String user_phone;
    private String user_icon;
    private String user_info;
    private String user_city;
    private String user_mail;
    private String user_address;
    private String user_intro;
    @JsonIgnore
    private Date user_creattime;
    @JsonIgnore
    private Date user_updatetime;

}
