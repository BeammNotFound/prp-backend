package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("志愿者实体类")
public class Volunteer {

    @JsonIgnore
    private Integer v_id;

    @NotNull(message = "用户名不能为空")
    private Integer user_id;
    @NotNull(message = "报名id不能为空")
    private Integer base_id;

    @JsonIgnore
    @ApiModelProperty("基地状态：1为开放志愿者，2为不开放志愿者，3为待开放志愿者")
    private Integer b_status;

    @JsonIgnore
    @ApiModelProperty("审批状态：1为审批通过，2为审批不通过，3为待审批")
    private Integer v_status;
    @JsonIgnore
    private Integer v_joinPopulation;
    @JsonIgnore
    private Integer v_population;

    @JsonIgnore
    private Date v_end_time;
    @JsonIgnore
    private Date v_start_time;
    @JsonIgnore
    private Date v_pass_time;
    @JsonIgnore
    private Date v_application_time;
}
