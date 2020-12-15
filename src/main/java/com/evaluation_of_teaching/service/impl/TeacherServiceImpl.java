package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public List<TeacherEntity> getTeachers() {
        return teacherMapper.selectAll();
    }

    public int addTeacher(TeacherEntity teacher) {
        return teacherMapper.insert(teacher);
    }

    public int updateTeacher(TeacherEntity teacher) {
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    public int deleteTeacher(TeacherEntity teacher) {
        return teacherMapper.delete(teacher);
    }
}
