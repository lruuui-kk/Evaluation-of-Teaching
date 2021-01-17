package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.dao.CourseMapper;
import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(path = "/getCourses")
    public List<CourseEntity> getCourses(int currentPage, String name, String dept){
        System.out.println("所有课程");
        return courseService.getCourses(currentPage,name,dept);
    }

    @RequestMapping(path = "/getCourseByDept")
    public List<CourseEntity> getCourseByDpet(String dept, int currentPage){
        return courseService.getCourseByDpet(dept,currentPage);
    }

    @RequestMapping(path = "/addCourse",method = RequestMethod.POST)
    public int addCourse(CourseEntity course){
        return courseService.addCourse(course);
    }

    @RequestMapping(path = "/updateCourse",method = RequestMethod.PUT)
    public int updateCourse(CourseEntity course){
        return courseService.updateCourse(course);
    }

    @RequestMapping(path = "/deleteCourse",method = RequestMethod.DELETE)
    public int deleteCourse(int courseId){
        return courseService.deleteCourse(courseId);
    }
}
