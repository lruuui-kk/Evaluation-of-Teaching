package com.evaluation_of_teaching.dto;

import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeaEvaluationDto {

    //评价者ID
    private Integer teacher_id;
    private String username;
    private String password;
    private String name;
    private String sno;
    private String sex;
    private String dept;

    private TeaEvaluationEntity teaEvaluation;

    private TeacherEntity teacher;//被评价者
}
