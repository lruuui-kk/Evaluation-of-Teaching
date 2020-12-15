package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.service.StuEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/stuEvaluation")
public class StuEvaluationController {

    @Autowired
    StuEvaluationService stuEvaluationService;

    @RequestMapping(path = "/getStuEvaluations",method = RequestMethod.GET)
    public List<StuEvaluationEntity> getStuEvaList(String userId){
        return stuEvaluationService.getStuEvaList(userId);
    }

    @RequestMapping(path = "/addStuEvaluation",method = RequestMethod.POST)
    int addStuEva(StuEvaluationEntity stuEvaluation){
        return stuEvaluationService.addStuEva(stuEvaluation);
    }
}