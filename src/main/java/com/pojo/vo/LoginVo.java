package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
