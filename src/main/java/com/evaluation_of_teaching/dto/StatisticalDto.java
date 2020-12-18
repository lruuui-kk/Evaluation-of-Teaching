package com.evaluation_of_teaching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticalDto {
    private String teaName;
    private String sno;
    private String sex;
    private String dept;
    private Integer stuScore;
    private Integer teaScore;
}
