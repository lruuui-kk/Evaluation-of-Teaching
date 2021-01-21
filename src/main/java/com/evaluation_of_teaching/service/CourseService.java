package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.CourseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseService {

    Map getCourses(int currentPage, String name, String dept);

    int addCourse(CourseEntity course);

    int updateCourse(CourseEntity Course);

    int deleteCourse(int courseId);
}
