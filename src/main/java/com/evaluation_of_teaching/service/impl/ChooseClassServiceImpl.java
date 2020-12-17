package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.ChooseClassMapper;
import com.evaluation_of_teaching.model.ChooseClassEntity;
import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.service.ChooseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChooseClassServiceImpl implements ChooseClassService {

    @Autowired
    ChooseClassMapper chooseClassMapper;

    public List<StudentEntity> queryChooseListByUser(int userId) {
        return chooseClassMapper.queryChooseListByUser(userId);
    }

    public int addChooseClass(int userId, int courseId) {
        ChooseClassEntity entity =new ChooseClassEntity();
        entity.setStudent_id(userId);
        entity.setCourse_id(courseId);
        return chooseClassMapper.insert(entity);
    }

    public int deleteChooseClass(int userId, int courseId) {
        return chooseClassMapper.deleteChooseClass(userId,courseId);
    }
}
