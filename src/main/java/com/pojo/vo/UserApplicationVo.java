package com.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserApplicationVo {
    @NotBlank(message = "用户名不能为空")
    private String user_name;
    private Integer b_id;
    private Integer b_joinPopulation;
    private Integer b_population;
    private Integer b_status;
}
