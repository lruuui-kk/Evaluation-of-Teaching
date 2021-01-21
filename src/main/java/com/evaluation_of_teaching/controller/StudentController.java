package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(path = "/getStudents",method = RequestMethod.GET)//POST不行
    public Map getStudents(int currentPage, String name, String dept){
        return studentService.getStudents(currentPage,name,dept);
    }

    @RequestMapping(path = "/addStudent",method = RequestMethod.POST)
    public int addStudent(StudentEntity studentEntity){
        return studentService.addStudent(studentEntity);
    }

    @RequestMapping(path = "/updateStudent",method = RequestMethod.PUT)
    public int updateStudent(StudentEntity studentEntity){
        return studentService.updateStudent(studentEntity);
    }

    @RequestMapping(path = "/deleteStudent",method = RequestMethod.DELETE)
    public int deleteStudent(int userId){
        return studentService.deleteStudent(userId);
    }
}
