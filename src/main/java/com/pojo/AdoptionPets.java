package com.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("领养宠物实体类")
public class AdoptionPets {
    private Integer ap_id;
    private Integer ap_base;
    private String ap_name;
    private String ap_age;
    private String ap_breed;
    @ApiModelProperty("宠物疾病史")
    private String ap_DH;
    private String ap_intro;
    private String ap_image_1;
    private String ap_image_2;
    private String ap_image_3;
    private String ap_image_4;
    private Date ap_createtime;
}
