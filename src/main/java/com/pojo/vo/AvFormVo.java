package com.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class AvFormVo {
    private Integer av_id;
    private String user_name;
    private String b_name;
    private String user_phone;
    private Integer vi_joinPopulation;
    private Integer vi_population;
    private Date av_application_time;
    private Date av_pass_time;
    private String av_status;
}
