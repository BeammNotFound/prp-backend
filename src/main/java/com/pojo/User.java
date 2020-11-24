package com.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体类")
public class User {
    @NotBlank(message = "请输入用户名")
    private String user_name;

    private String user_password;

    private String user_realname;

    @Email
    private String user_mail;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号格式不正确")
    private String user_phone;

    private String user_nickname;
    private String user_icon;
    private String user_info;
    private String user_city;
    private String user_address;
    private String user_intro;
    private Date user_createtime;
    private Date user_updatetime;

    @ApiModelProperty("user_type:1是普通用户，2是管理员；如果不传默认为用户权限")
    private Integer user_type;

    private String enter_password;

    private String user_tooken;

}
