package com.pojo;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@ApiModel("基地信息实体类")
public class BaseMessages {
    private Integer bm_id;
    private Integer bm_base_id;
    private String bm_title;
    private String bm_detail;
    private String bm_author;
    private String bm_image;
    private Date bm_createtime;
    
}
