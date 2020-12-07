package com.pojo.vo;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class QueryBasesVo {
    @NotBlank(message = "搜索内容不能为空")
    private String b_name;
}
