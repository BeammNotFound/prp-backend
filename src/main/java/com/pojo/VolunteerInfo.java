package com.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("志愿者实体类")
public class VolunteerInfo extends Bases{
    private Integer vi_id;

    private Integer base_id;

    @ApiModelProperty("志愿者状态")
    private String vi_status;

    private String vi_requirement;
    private String vi_intro;
    private Integer vi_joinPopulation;
    private Integer vi_population;

    private String bi_image1,bi_image2,bi_image3,bi_image4,bi_image5;

    private Date vi_end_time;
    private Date vi_start_time;
    private Date vi_create_time;

}
