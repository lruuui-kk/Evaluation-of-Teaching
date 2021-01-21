package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.dto.TeaEvaluationDto;
import com.evaluation_of_teaching.dto.stuEvaDto;
import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.TeaEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/teaEvaluation")
public class TeaEvaluationController {

    @Autowired
    TeaEvaluationService teaEvaluationService;

    @RequestMapping(path = "/getTeaEvaluations",method = RequestMethod.GET)
    public Map getTeaEvaList(int currentPage, int userId){
        return teaEvaluationService.getTeaEvaList(currentPage,userId);
    }

    @RequestMapping(path = "/queryTeaEva",method = RequestMethod.GET)
    public TeacherEntity queryTeaEva(int id1, int id2){
        return teaEvaluationService.queryTeaEva(id1,id2);
    }

    @RequestMapping(path = "/queryAllTeaEva",method = RequestMethod.GET)
    public Map queryAllTeaEva(int currentPage){
        return teaEvaluationService.queryAllTeaEva(currentPage);
    }

    @RequestMapping(path = "/addTeaEvaluation",method = RequestMethod.POST)
    int addTeaEva(TeaEvaluationEntity teaEvaluation){
        return teaEvaluationService.addTeaEva(teaEvaluation);
    }

    @RequestMapping(path = "/queryStuEvaById",method = RequestMethod.GET)
    public Map queryStuEvaById(int currentPage, int id){
        return teaEvaluationService.queryStuEvaById(currentPage,id);
    }

    @RequestMapping(path = "/queryTeaEvaById",method = RequestMethod.GET)
    public Map queryTeaEvaById(int currentPage, int id){
        return teaEvaluationService.queryTeaEvaById(currentPage,id);
    }
}
