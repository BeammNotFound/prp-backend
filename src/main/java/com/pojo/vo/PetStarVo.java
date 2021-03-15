package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class PetStarVo {
    private Integer user_id;
    private Integer pi_id;
    @JsonIgnore
    private Date ps_create_time;
}
