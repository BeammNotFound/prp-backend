package com.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseIdVo {
    @NotNull(message = "基地id不能为空")
    private Integer base_id;
}
