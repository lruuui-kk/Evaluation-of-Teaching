package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.service.TeaEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/teaEvaluation")
public class TeaEvaluationController {

    @Autowired
    TeaEvaluationService teaEvaluationService;

    @RequestMapping(path = "/getTeaEvaluations",method = RequestMethod.GET)
    List<TeaEvaluationEntity> getTeaEvaList(String userId){
        return teaEvaluationService.getTeaEvaList(userId);
    }

    @RequestMapping(path = "/addTeaEvaluation",method = RequestMethod.POST)
    int addTeaEva(TeaEvaluationEntity teaEvaluation){
        return teaEvaluationService.addTeaEva(teaEvaluation);
    }
}
