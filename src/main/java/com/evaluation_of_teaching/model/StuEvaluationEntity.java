package com.evaluation_of_teaching.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stu_evaluation")
public class StuEvaluationEntity {
    @Id
    private Integer stu_evaluation_id;
    private Integer student_id;
    private Integer teacher_id;
    private Integer str1;
    private Integer str2;
    private Integer str3;
    private Integer str4;
    private Integer str5;
    private Integer str6;
    private Integer sum;
    private String content;
}
