package com.evaluation_of_teaching.dto;

import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuEvaluationDto {

    private StuEvaluationEntity stuEvaluation;
    private CourseEntity course;
    private StudentEntity student;
    private TeacherEntity teacher;
}
