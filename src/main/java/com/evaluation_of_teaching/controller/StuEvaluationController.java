package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.dto.StuEvaluationDto;
import com.evaluation_of_teaching.dto.courseTeacherDto;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.service.StuEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/stuEvaluation")
public class StuEvaluationController {

    @Autowired
    StuEvaluationService stuEvaluationService;

    @RequestMapping(path = "/getStuEvaluations",method = RequestMethod.GET)
    public Map getStuEvaList(int currentPage, int userId){
        return stuEvaluationService.getStuEvaList(currentPage,userId);
    }

    @RequestMapping(path = "/queryStuEva",method = RequestMethod.GET)
    public courseTeacherDto queryStuEva(int userId, int courseId){
        return stuEvaluationService.queryStuEva(userId,courseId);
    }

    @RequestMapping(path = "/queryAllStuEva",method = RequestMethod.GET)
    public Map queryAllStuEva(int currentPage){
        return stuEvaluationService.queryAllStuEva(currentPage);
    }

    @RequestMapping(path = "/addStuEvaluation",method = RequestMethod.POST)
    int addStuEva(StuEvaluationEntity stuEvaluation){
        return stuEvaluationService.addStuEva(stuEvaluation);
    }
}
