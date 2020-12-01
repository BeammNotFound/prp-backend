package com.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class UserIdVo {
    @NotNull(message = "用户id不能为空")
    private Integer user_id;
}
