package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("科普实体类")
public class Popularizations {
    @NotBlank(message = "标题不能为空")
    private String p_title;
    @NotBlank(message = "内容不能为空")
    private String p_details;
    @NotBlank(message = "作者不能为空")
    private String p_author;
    @NotNull(message = "科普类型不能为空")
    @ApiModelProperty("科普类型： 1 品种科普; 2 动物常患疾病; 3 动物冷知识")
    private Integer p_type;
    @JsonIgnore
    private Integer p_pv;
    @JsonIgnore
    private Date p_createtime;
    @JsonIgnore
    private Date p_updatetime;
    @ApiModelProperty("如果没有图片可以不传")
    private String p_image;
}
