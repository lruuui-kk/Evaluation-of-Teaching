package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.dto.stuEvaDto;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
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
    public List<TeaEvaluationEntity> getTeaEvaList(int userId){
        return teaEvaluationService.getTeaEvaList(userId);
    }

    @RequestMapping(path = "/queryTeaEva",method = RequestMethod.GET)
    public TeacherEntity queryTeaEva(int id1, int id2){
        return teaEvaluationService.queryTeaEva(id1,id2);
    }

    @RequestMapping(path = "/addTeaEvaluation",method = RequestMethod.POST)
    int addTeaEva(TeaEvaluationEntity teaEvaluation){
        return teaEvaluationService.addTeaEva(teaEvaluation);
    }

    @RequestMapping(path = "/queryStuEvaById",method = RequestMethod.GET)
    public List<stuEvaDto> queryStuEvaById(int id){
        return teaEvaluationService.queryStuEvaById(id);
    }

    @RequestMapping(path = "/queryTeaEvaById",method = RequestMethod.GET)
    public List<TeaEvaluationEntity> queryTeaEvaById(int id){
        return teaEvaluationService.queryTeaEvaById(id);
    }
}
