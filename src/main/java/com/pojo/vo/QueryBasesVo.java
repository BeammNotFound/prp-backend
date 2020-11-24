package com.pojo.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryBasesVo {
    @NotBlank(message = "搜索内容不能为空")
    private String b_name;
}
