package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.StuEvaluationMapper;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.service.StuEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
public class StuEvaluationServiceImpl implements StuEvaluationService {

    @Autowired
    StuEvaluationMapper stuEvaluationMapper;

    public List<StuEvaluationEntity> getStuEvaList(String userId) {
        Example example = new Example(Example.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("student_id",userId);
        return stuEvaluationMapper.selectByExample(example);
    }

    public int addStuEva(StuEvaluationEntity stuEvaluation) {
        return stuEvaluationMapper.insert(stuEvaluation);
    }
}
