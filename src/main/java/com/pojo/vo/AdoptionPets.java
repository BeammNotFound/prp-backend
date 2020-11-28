package com.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionPets {
    private Integer ap_id;
    private Integer ap_base;
    private String ap_name;
    private String ap_age;
    private String ap_breed;
    @ApiModelProperty("宠物疾病史")
    private String ap_DH;
    private String ap_intro;
    private String ap_image;
    private Date ap_createtime;
}
