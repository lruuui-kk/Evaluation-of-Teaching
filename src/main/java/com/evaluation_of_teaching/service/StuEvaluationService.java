package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.StuEvaluationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuEvaluationService {
    List<StuEvaluationEntity> getStuEvaList(String userId);

    int addStuEva(StuEvaluationEntity stuEvaluation);
}
