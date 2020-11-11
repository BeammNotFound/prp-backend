package com.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体类")
public class User {
    private String user_name;
    private String user_nickname;
    private String user_realname;
    private String user_password;
    @ApiModelProperty("user_type:1是普通用户，2是管理员；如果不传默认为用户权限")
    private Integer user_type;
    private String user_phone;
    private String user_icon;
    private String user_info;
    private String user_city;
    private String user_mail;
    private String user_address;
    private String user_intro;
    @JsonIgnore
    private Date user_createtime;
    @JsonIgnore
    private Date user_updatetime;

}
