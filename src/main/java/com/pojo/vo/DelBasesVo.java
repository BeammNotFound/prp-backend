package com.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelBasesVo{
    @NotNull(message = "要删除的基地id不能为空")
    private Integer b_id;
}
