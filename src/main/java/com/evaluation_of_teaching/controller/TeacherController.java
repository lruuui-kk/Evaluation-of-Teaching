package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping(path = "/getTeachers")
    public Map getTeachers(int currentPage, String name, String dept){
        return teacherService.getTeachers(currentPage, name, dept);
    }

    @RequestMapping(path = "/addTeacher",method = RequestMethod.POST)
    public int addTeacher(TeacherEntity teacher){
        return teacherService.addTeacher(teacher);
    }

    @RequestMapping(path = "/updateTeacher",method = RequestMethod.PUT)
    public int updateTeacher(TeacherEntity teacher){
        return teacherService.updateTeacher(teacher);
    }

    @RequestMapping(path = "/deleteTeacher",method = RequestMethod.DELETE)
    public int deleteTeacher(int userId){
        return teacherService.deleteTeacher(userId);
    }

}
