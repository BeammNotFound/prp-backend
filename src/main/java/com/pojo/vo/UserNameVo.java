package com.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class UserNameVo {
    @NotBlank(message = "用户名不能为空")
    private String user_name;
}
