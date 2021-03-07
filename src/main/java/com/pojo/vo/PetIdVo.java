package com.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class PetIdVo {
    @NotNull(message = "pi_id不能为空")
    private Integer pi_id;
}
