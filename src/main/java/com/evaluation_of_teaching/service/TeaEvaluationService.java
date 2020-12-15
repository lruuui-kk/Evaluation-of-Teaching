package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeaEvaluationService {

    List<TeaEvaluationEntity> getTeaEvaList(String userId);

    int addTeaEva(TeaEvaluationEntity teaEvaluation);
}
