package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("志愿者实体类")
public class VolunteerInfo extends Bases{

    @JsonIgnore
    private Integer vi_id;

    private Integer base_id;

    @ApiModelProperty("志愿者状态")
    private String vi_status;

    private String vi_requirement;
    private String vi_intro;
    private Integer vi_joinPopulation;
    private Integer vi_population;

    private Date vi_end_time;
    private Date vi_start_time;
    private Date vi_create_time;

}
