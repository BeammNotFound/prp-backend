package com.pojo.vo;

import lombok.Data;
import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class PetsInfoVo {
    private String pi_name,pi_breed,pi_age,pi_DH,ap_status,user_name,user_phone,b_name;
    private Integer pi_id;
    private Date ap_pass_time,pi_createtime;
}
