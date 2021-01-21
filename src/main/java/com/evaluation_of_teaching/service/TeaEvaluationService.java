package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.dto.TeaEvaluationDto;
import com.evaluation_of_teaching.dto.stuEvaDto;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeaEvaluationService {

    Map getTeaEvaList(int currentPage, int userId);

    TeacherEntity queryTeaEva(int id1, int id2);

    Map queryAllTeaEva(int currentPage);

    int addTeaEva(TeaEvaluationEntity teaEvaluation);

    Map queryStuEvaById(int currentPage, int id);

    Map queryTeaEvaById(int currentPage, int id);
}
