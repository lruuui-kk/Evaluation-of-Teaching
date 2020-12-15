package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.service.ChooseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/choose")
public class ChooseClassController {

    @Autowired
    ChooseClassService service;

    @RequestMapping(path = "/queryChoose")
    public List<StudentEntity> queryChooseListByUser(String userId){
        return service.queryChooseListByUser(userId);
    }

    @RequestMapping(path = "/addChoose",method = RequestMethod.POST)
    public int addChooseClass(String userId,String courseId){
        return service.addChooseClass(userId,courseId);
    }

    @RequestMapping(path = "/deleteChoose",method = RequestMethod.DELETE)
    int deleteChooseClass(String userId,String courseId){
        return service.deleteChooseClass(userId,courseId);
    }
}
