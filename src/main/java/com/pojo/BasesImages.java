package com.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("背景图片实体类")
public class BasesImages {
    private Integer bi_id;
    private Integer base_id;
    private String bi_image;
    private Date bi_createtime;
}
