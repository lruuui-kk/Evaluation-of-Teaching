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

    public List<StudentEntity> queryChooseListByUser(String userId) {
        List<StudentEntity> list = chooseClassMapper.queryChooseListByUser(userId);

        return list;
    }

    public int addChooseClass(String userId, String courseId) {
        ChooseClassEntity entity =new ChooseClassEntity();
        entity.setStudent_id(userId);
        entity.setCourse_id(courseId);
        return chooseClassMapper.insert(entity);
    }

    public int deleteChooseClass(String userId, String courseId) {
        return chooseClassMapper.deleteChooseClass(userId,courseId);
    }
}
