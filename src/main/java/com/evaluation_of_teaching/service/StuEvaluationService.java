package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.dto.courseTeacherDto;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface StuEvaluationService {
    Map getStuEvaList(int currentPage, int userId);

    courseTeacherDto queryStuEva(int userId,int courseId);

    Map queryAllStuEva(int currentPage);

    int addStuEva(StuEvaluationEntity stuEvaluation);
}
