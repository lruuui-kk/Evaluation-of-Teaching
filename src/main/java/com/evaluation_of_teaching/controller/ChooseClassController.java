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
    ChooseClassService chooseClassService;

    @RequestMapping(path = "/queryChoose")
    public List<StudentEntity> queryChooseListByUser(int userId){
        return chooseClassService.queryChooseListByUser(userId);
    }

    @RequestMapping(path = "/addChoose",method = RequestMethod.POST)
    public int addChooseClass(int userId,int courseId){
        return chooseClassService.addChooseClass(userId,courseId);
    }

    @RequestMapping(path = "/deleteChoose",method = RequestMethod.DELETE)
    public int deleteChooseClass(int userId,int courseId){
        return chooseClassService.deleteChooseClass(userId,courseId);
    }
}
