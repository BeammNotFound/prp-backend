package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasesImages {
    private Integer bi_id;
    private Integer base_id;
    private String bi_image;
    private Date bi_createtime;
}
