package com.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class BaseIdVo {
    @NotNull(message = "基地id不能为空")
    private Integer base_id;
}
