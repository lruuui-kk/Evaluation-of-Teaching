package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.ChooseClassMapper;
import com.evaluation_of_teaching.model.ChooseClassEntity;
import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.service.ChooseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ChooseClassServiceImpl implements ChooseClassService {

    @Autowired
    ChooseClassMapper chooseClassMapper;

    /**
     * 传入学生id查询该学生的所有选课
     * 该方法调用dao层没用tk通用mapper 而是用的Mybatis传统xml方法
     * @param currentPage
     * @param userId 学生ID
     * @return
     */
    public Map queryChooseListByUser(int currentPage, int userId) {
        Map map = new HashMap();
        Example example = new Example(StudentEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("student_id",userId);
        List<StudentEntity> chooseClassList = chooseClassMapper.queryChooseListByUser(currentPage,userId);
        int count = chooseClassMapper.selectCountByExample(example);
        map.put("data",chooseClassList);
        map.put("count",count);
        return map;
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
