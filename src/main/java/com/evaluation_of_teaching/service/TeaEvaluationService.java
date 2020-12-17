package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeaEvaluationService {

    List<TeaEvaluationEntity> getTeaEvaList(int userId);

    TeacherEntity queryTeaEva(int id1, int id2);

    int addTeaEva(TeaEvaluationEntity teaEvaluation);
}
