package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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

    private String b_icon;
    private String b_image;

    @ApiModelProperty("参加人数")
    private Integer b_joinPopulation;

    @NotBlank(message = "报名人数不能为空")
    @ApiModelProperty("报名人数")
    private Integer b_population;

    @ApiModelProperty("基地的联系人姓名")
    private String b_contacts;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号格式不正确")
    private String b_phone;
    @Email(message = "邮箱格式不正确")
    private String b_mail;

    @JsonIgnore
    private Date b_createtime;

    private Date b_endtime;

}
