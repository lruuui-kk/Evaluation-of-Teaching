package com.evaluation_of_teaching.dto;

import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class courseTeacherDto {

    private TeacherEntity teacher;
    private CourseEntity course;

}
