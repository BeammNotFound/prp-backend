package com.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@ApiModel("基地实体类")
public class Bases {
    private Integer base_id;

    @NotBlank(message = "基地名不能为空")
    private String b_name;
    @NotBlank(message = "基地地址不能为空")
    private String b_address;
    @NotBlank(message = "基地简介不能为空")
    private String b_intro;
    private String b_icon;
    @ApiModelProperty("基地的联系人姓名")
    private String b_contacts;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号格式不正确")
    private String b_phone;
    @Email(message = "邮箱格式不正确")
    private String b_mail;

    @ApiModelProperty("参加人数")
    private Integer vi_joinPopulation;

    @NotBlank(message = "报名人数不能为空")
    @ApiModelProperty("报名人数")
    private Integer vi_population;

    @ApiModelProperty("志愿者状态：1为可报名，2为不可报名（已满）")
    private String vi_status;

    private String vi_title;
    private String vi_intro;
    private Date b_createtime;
    private Date vi_end_time;
    private Date vi_start_time;

}
