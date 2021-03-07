package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class ApStatusVo {
    private Integer ap_id;
    @ApiModelProperty("审批状态： 1 审批通过; 2 待审批; 3 审批驳回")
    private Integer status;
    @JsonIgnore
    private String ap_status;
    @JsonIgnore
    private Date ap_pass_time;
}
