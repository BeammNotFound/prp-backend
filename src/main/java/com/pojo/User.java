package com.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体类")
public class User {
    @NotBlank(message = "用户名不能为空")
    private String user_name;
    @NotBlank(message = "密码不能为空")
    private String user_password;
//    @NotBlank(message = "真实姓名不能为空")
    private String user_realname;
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String user_mail;
    private String user_nickname;
    private String user_phone;
    private String user_icon;
    private String user_info;
    private String user_city;
    private String user_address;
    private String user_intro;
    @JsonIgnore
    private Date user_createtime;
    @JsonIgnore
    private Date user_updatetime;

    @ApiModelProperty("user_type:1是普通用户，2是管理员；如果不传默认为用户权限")
    private Integer user_type;
    @ApiModelProperty("只用于修改密码输入原密码接口，其他接口无需传参")
    private String enter_password;

    private String mail_code;

}
