package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.CourseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseService {

    List<CourseEntity> getCourses();

    int addCourse(CourseEntity course);

    int updateCourse(CourseEntity Course);

    int deleteCourse(CourseEntity Course);
}
