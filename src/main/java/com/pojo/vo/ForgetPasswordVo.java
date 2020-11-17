package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgetPasswordVo {

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String user_mail;

    @ApiModelProperty("邮箱验证码")
    @NotBlank(message = "验证码不能为空")
    private String mail_code;

    @NotBlank(message = "密码不能为空")
    @Size(min = 8, max = 16, message = "密码长度为8-16")
    private String user_password;

    @JsonIgnore
    private Date user_updatetime;

}
