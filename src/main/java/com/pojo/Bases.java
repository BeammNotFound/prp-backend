package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bases {
    private Integer b_id;

    private String b_name;
    private String b_address;
    private String b_intro;
    private Integer b_status;

    private String b_image;

    private Date b_createtime;
}
