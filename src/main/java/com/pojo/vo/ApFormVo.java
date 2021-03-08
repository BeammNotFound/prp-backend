package com.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class ApFormVo{
    private Integer ap_id;
    private Integer status,user_id;
    private String user_name;
    private String b_name;
    private String pi_name;
    private String user_phone;
    private String ap_status;
    private Date ap_pass_time;
    private Date ap_application_time;
}
