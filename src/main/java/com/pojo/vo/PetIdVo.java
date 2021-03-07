package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class PetIdVo {
    private Integer pi_id;
    @JsonIgnore
    private Integer pet_id;
}
