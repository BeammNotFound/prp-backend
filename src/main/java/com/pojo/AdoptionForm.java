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
    @NotBlank(message = "该数据不能为空")
    private String af_address;
    @NotNull(message = "该数据不能为空")
    private Integer af_age;
    @NotBlank(message = "该数据不能为空")
    private String af_appraise;
    @NotBlank(message = "该数据不能为空")
    private String af_info1;
    @NotBlank(message = "该数据不能为空")
    private String af_info2;
    @NotBlank(message = "该数据不能为空")
    private String af_info3;
    @NotBlank(message = "该数据不能为空")
    private String af_info4;
    @NotBlank(message = "该数据不能为空")
    private String af_info5;
    @NotBlank(message = "该数据不能为空")
    private String af_info6;
    private String user_id;
    private Integer base_id;
    private Integer pet_id;
    @JsonIgnore
    private Date af_createTime;
}
