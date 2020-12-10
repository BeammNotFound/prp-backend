package com.pojo.vo;

import com.pojo.Bases;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class QueryVolunteerByIdVo extends Bases {
    @NotBlank(message = "用户id不能为空")
    private Integer user_id;

    private String av_status;
    private Date av_pass_time;
    private Date av_application_time;
}
