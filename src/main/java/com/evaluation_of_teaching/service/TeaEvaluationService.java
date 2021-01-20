package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.dto.TeaEvaluationDto;
import com.evaluation_of_teaching.dto.stuEvaDto;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeaEvaluationService {

    List<TeaEvaluationEntity> getTeaEvaList(int userId);

    TeacherEntity queryTeaEva(int id1, int id2);

    List<TeaEvaluationDto> queryAllTeaEva(int currentPage);

    int addTeaEva(TeaEvaluationEntity teaEvaluation);

    List<stuEvaDto> queryStuEvaById(int id);

    List<TeaEvaluationEntity> queryTeaEvaById(int id);
}
