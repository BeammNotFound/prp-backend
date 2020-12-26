package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class UpdateUserInfoVo {
    @NotNull(message = "user_id不能为空")
    private Integer user_id;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号格式不正确")
    private String user_phone;
    private String user_realname;
    private String user_nickname;
    private String user_icon;
    private String user_info;
    private String user_city;
    private String user_address;
    private String user_intro;
    private String user_sex;
    private Integer user_age;
    @JsonIgnore
    private Date user_updatetime;

}
