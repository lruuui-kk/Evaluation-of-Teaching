package com.evaluation_of_teaching.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_evaluation")
public class TeaEvaluationEntity {
    @Id
    private Integer t_evaluation_id;
    private String teacher_id1;
    private String teacher_id2;
    private Integer str1;
    private Integer str2;
    private Integer str3;
    private Integer str4;
    private Integer str5;
    private Integer str6;
    private Integer sum;
    private String content;
}
