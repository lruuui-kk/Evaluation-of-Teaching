package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.StudentMapper;
import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    public List<StudentEntity> getStudents() {
        return studentMapper.getStudents();
    }

    public int addStudent(StudentEntity student) {
        return studentMapper.addStudent(student);
    }

    public int updateStudent(StudentEntity student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    public int deleteStudent(StudentEntity student) {
        return studentMapper.delete(student);
    }
}
