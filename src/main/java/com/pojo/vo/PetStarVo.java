package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class PetStarVo {
    private Integer user_id;
    @JsonIgnore
    private Integer pi_id;
}
