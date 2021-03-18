package com.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class StarredPetsVo {
    private Integer user_age,ps_id;
    private String pi_name,pi_age,pi_breed,user_realname,user_sex,user_city;
    private Date ps_create_time;
}
