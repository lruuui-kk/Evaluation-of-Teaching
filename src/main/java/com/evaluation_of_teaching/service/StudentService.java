package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentService {

    List<StudentEntity> getStudents();

    int addStudent(StudentEntity student);

    int updateStudent(StudentEntity student);

    int deleteStudent(StudentEntity student);
}
