package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.TeacherService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public List<TeacherEntity> getTeachers(int currentPage) {
        RowBounds rowBounds =new RowBounds((currentPage-1)*10,10);
        return teacherMapper.selectByRowBounds(null,rowBounds);
    }

    public int addTeacher(TeacherEntity teacher) {
        return teacherMapper.insert(teacher);
    }

    public int updateTeacher(TeacherEntity teacher) {
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    public int deleteTeacher(int userId) {
        return teacherMapper.deleteByPrimaryKey(userId);
    }
}
