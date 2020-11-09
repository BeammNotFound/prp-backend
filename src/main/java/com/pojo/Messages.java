package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messages {
    private int id;
    private String title;
    private String details;
    private String author;
    private String image;
    private Date create_time;
    private Date update_time;
}
