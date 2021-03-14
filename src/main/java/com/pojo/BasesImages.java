package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("背景图片实体类")
public class BasesImages {
    private Integer bi_id;

    @JsonIgnore
    private String bi_image;
    @JsonIgnore
    private Integer base_id;
    @JsonIgnore
    private Date bi_createtime;
}
