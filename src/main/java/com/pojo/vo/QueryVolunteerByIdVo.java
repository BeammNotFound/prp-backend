package com.pojo.vo;

import com.pojo.VolunteerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryVolunteerByIdVo extends VolunteerInfo {
    @NotBlank(message = "用户id不能为空")
    private Integer user_id;

    private String av_status;
    private Date av_pass_time;
    private Date av_application_time;
    private Integer base_id;
}
