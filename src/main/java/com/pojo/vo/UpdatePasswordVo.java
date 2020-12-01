package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class UpdatePasswordVo {
    @NotBlank(message = "用户名不能为空")
    private String user_name;

    @NotBlank(message = "新密码不能为空")
    @Size(min = 8, max = 16, message = "密码长度为8-16")
    private String user_password;

    @ApiModelProperty("原密码")
    @NotBlank(message = "原密码不能为空")
    private String enter_password;

    @JsonIgnore
    private Date user_updatetime;
}
