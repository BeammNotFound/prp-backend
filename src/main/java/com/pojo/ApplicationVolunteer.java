package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class ApplicationVolunteer {
    private Integer vi_id;
    private Integer user_id;
    private Integer base_id;
    private String av_status;

    @JsonIgnore
    private Date av_application_time;

    @JsonIgnore
    private String vi_status;

}
