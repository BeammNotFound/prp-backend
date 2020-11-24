package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("基地实体类")
public class Bases {
    private Integer b_id;

    @NotBlank(message = "基地名不能为空")
    private String b_name;
    @NotBlank(message = "基地地址不能为空")
    private String b_address;
    @NotBlank(message = "基地简介不能为空")
    private String b_intro;
    @ApiModelProperty("基地状态：1为可报名，2为不可报名（已满）")
    private Integer b_status;

    private String b_image;

    @ApiModelProperty("参加人数")
    private Integer b_joinPopulation;

    @NotBlank(message = "报名人数不能为空")
    @ApiModelProperty("报名人数")
    private Integer b_population;

    @JsonIgnore
    private Date b_createtime;
}
