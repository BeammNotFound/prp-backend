package com.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class VolunteerInfoVo{
    private String vi_requirement,vi_intro;
    private Integer vi_population,vi_id,base_id;
    private Date vi_start_time,vi_end_time;
}
