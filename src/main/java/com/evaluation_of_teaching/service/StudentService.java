package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentService {

    Map getStudents(int currentPage, String name, String dept);

    int addStudent(StudentEntity student);

    int updateStudent(StudentEntity student);

    int deleteStudent(int userId);
}
