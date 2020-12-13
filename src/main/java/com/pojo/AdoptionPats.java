package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
@ApiModel("领养宠物实体类")
public class AdoptionPats extends AdoptionForm{
    @JsonIgnore
    private Integer ap_id;

    @NotNull(message = "user_id不能为空")
    private Integer user_id;
    @NotNull(message = "base_id不能为空")
    private Integer base_id;
    @NotNull(message = "pet_id不能为空")
    private Integer pet_id;

    @ApiModelProperty("领养状态：1为审批通过，2为待审批，3为审批不通过")
    @JsonIgnore
    private Integer ap_status;
    @JsonIgnore
    private Date ap_application_time;
    @JsonIgnore
    private Date ap_pass_time;

}
