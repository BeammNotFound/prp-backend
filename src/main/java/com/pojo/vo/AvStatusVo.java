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
public class AvStatusVo {
    @ApiModelProperty("审批状态： 1 审批通过; 2 待审批; 3 审批驳回")
    private Integer status;
    @JsonIgnore
    private String av_status;
    @JsonIgnore
    private Date av_pass_time;
}
