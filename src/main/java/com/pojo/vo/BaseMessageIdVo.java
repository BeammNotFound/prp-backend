package com.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class BaseMessageIdVo {
    @NotNull(message = "请输入bm_id")
    Integer bm_id;
}
