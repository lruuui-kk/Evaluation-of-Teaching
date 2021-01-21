package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.TeacherEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeacherService {
    Map getTeachers(int currentPage, String name, String dept);

    int addTeacher(TeacherEntity teacher);

    int updateTeacher(TeacherEntity teacher);

    int deleteTeacher(int userId);
}
