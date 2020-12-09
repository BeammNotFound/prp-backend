package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
@ApiModel("志愿者实体类")
public class ApplicationVolunteer {
    @NotNull(message = "user_id不能为空")
    private Integer user_id;
    @NotNull(message = "base_id不能为空")
    private Integer base_id;
    @JsonIgnore
    private String av_status;

    @JsonIgnore
    private Date av_application_time;

    @JsonIgnore
    private String vi_status;

}
