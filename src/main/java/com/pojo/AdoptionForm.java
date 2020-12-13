package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
@ApiModel("报名志愿者实体类")
public class AdoptionForm {
    @NotBlank(message = "af_address不能为空")
    private String af_address;
    @NotNull(message = "af_age不能为空")
    private Integer af_age;
    @NotBlank(message = "af_appraise不能为空")
    private String af_appraise;
    @NotBlank(message = "af_info1不能为空")
    private String af_info1;
    @NotBlank(message = "af_info2不能为空")
    private String af_info2;
    @NotBlank(message = "af_info3不能为空")
    private String af_info3;
    @NotBlank(message = "af_info4不能为空")
    private String af_info4;
    @NotBlank(message = "af_info5不能为空")
    private String af_info5;
    @NotBlank(message = "af_info6不能为空")
    private String af_info6;

    @JsonIgnore
    private Date af_create_time;
}
