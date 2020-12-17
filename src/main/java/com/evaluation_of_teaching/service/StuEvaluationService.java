package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.dto.courseTeacherDto;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuEvaluationService {
    List<StuEvaluationEntity> getStuEvaList(int userId);

    courseTeacherDto queryStuEva(int userId,int courseId);

    int addStuEva(StuEvaluationEntity stuEvaluation);
}
