package com.evaluation_of_teaching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class stuEvaDto {
    private Integer student_id;
    private Integer course_id;
    private Integer str1;
    private Integer str2;
    private Integer str3;
    private Integer str4;
    private Integer str5;
    private Integer str6;
    private Integer sum;
    private String content;

    private String course_name;
    private String dept;
    private String term;
    private Date start_time;
    private Date end_time;
    private String place;
    private Integer num;
    private String teacher_name;
}
