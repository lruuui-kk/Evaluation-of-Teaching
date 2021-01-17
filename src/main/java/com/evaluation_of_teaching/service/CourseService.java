package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.CourseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseService {

    List<CourseEntity> getCourses(int currentPage, String name, String dept);

    List<CourseEntity> getCourseByDpet(String dept, int currentPage);

    int addCourse(CourseEntity course);

    int updateCourse(CourseEntity Course);

    int deleteCourse(int courseId);
}
