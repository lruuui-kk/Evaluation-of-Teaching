package com.evaluation_of_teaching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticalDto {
    private String teaName;
    private Integer courseId;
    private String courseName;
    private String dept;
    private Integer num;
    private Integer stuScore;
    private Integer teaScore;
}
