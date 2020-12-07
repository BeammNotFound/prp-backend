package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginVo {
    @NotBlank(message = "用户名不能为空")
    private String user_name;
    @NotBlank(message = "密码不能为空")
    private String user_password;
    @JsonIgnore
    private String user_nickname;
    @JsonIgnore
    private String tooken;

}
