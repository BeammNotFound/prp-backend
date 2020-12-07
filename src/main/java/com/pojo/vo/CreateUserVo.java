package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class CreateUserVo {

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String user_mail;

    @NotBlank(message = "密码不能为空")
    @Size(min = 8, max = 16, message = "密码长度为8-16")
    private String user_password;

    @ApiModelProperty("昵称")
    @NotBlank(message = "昵称不能为空")
    @Size(min = 2, max = 10, message = "昵称长度为2-10")
    private String user_nickname;

    @ApiModelProperty("邮箱验证码")
    @NotBlank(message = "验证码不能为空")
    private String mail_code;

    @JsonIgnore
    private String user_name;
    @JsonIgnore
    private Date user_createtime;
    @JsonIgnore
    private Date user_updatetime;
    @JsonIgnore
    private Integer user_type;

}
