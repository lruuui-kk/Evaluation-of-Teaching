package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.StudentMapper;
import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.service.StudentService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    public List<StudentEntity> getStudents(int currentPage) {
        RowBounds rowBounds =new RowBounds((currentPage-1)*10,10);
        return studentMapper.selectByRowBounds(null,rowBounds);
    }

    public int addStudent(StudentEntity student) {
        return studentMapper.addStudent(student);
    }

    public int updateStudent(StudentEntity student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    public int deleteStudent(int userId) {
        return studentMapper.deleteByPrimaryKey(userId);
    }
}
