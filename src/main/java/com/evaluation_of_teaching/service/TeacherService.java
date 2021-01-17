package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.TeacherEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherService {
    List<TeacherEntity> getTeachers(int currentPage, String name, String dept);

    int addTeacher(TeacherEntity teacher);

    int updateTeacher(TeacherEntity teacher);

    int deleteTeacher(int userId);
}
