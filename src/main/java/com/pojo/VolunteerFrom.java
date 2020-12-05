package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class VolunteerFrom {
    @NotBlank(message = "该数据不能为空")
    private String vf_address;
    @NotBlank(message = "该数据不能为空")
    private String vf_age;
    @NotBlank(message = "该数据不能为空")
    private String vf_appraise;
    @NotBlank(message = "该数据不能为空")
    private String vf_info1;
    @NotBlank(message = "该数据不能为空")
    private String vf_info2;
    @NotBlank(message = "该数据不能为空")
    private String vf_info3;
    @NotBlank(message = "该数据不能为空")
    private String vf_info4;
    @NotBlank(message = "该数据不能为空")
    private String vf_info5;
    @NotBlank(message = "该数据不能为空")
    private String vf_info6;
    private String user_id;
    private Integer base_id;
    @JsonIgnore
    private Date vf_createTime;
}
