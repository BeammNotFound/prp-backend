package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pojo.Volunteer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryVolunteerByIdVo extends Volunteer {
    @NotBlank(message = "用户id不能为空")
    private Integer user_id;

    private String user_realname;
    private Integer user_application;
    private String user_phone;


    private String b_icon;
    private String b_id;
    private String b_name;
    private String b_mail;
    private String b_address;
    private String b_phone;
    private String b_contacts;
    private String b_intro;

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
