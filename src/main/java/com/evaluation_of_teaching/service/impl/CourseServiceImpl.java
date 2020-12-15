package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.CourseMapper;
import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    public List<CourseEntity> getCourses() {
        return courseMapper.selectAll();
    }

    public int addCourse(CourseEntity course) {
        return courseMapper.insert(course);
    }

    public int updateCourse(CourseEntity course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    public int deleteCourse(CourseEntity course) {
        return courseMapper.delete(course);
    }
}
