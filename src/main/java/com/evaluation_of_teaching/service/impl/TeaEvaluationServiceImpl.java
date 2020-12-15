package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.TeaEvaluationMapper;
import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.service.TeaEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Component
public class TeaEvaluationServiceImpl implements TeaEvaluationService {

    @Autowired
    TeaEvaluationMapper teaEvaluationMapper;
    @Override
    public List<TeaEvaluationEntity> getTeaEvaList(String userId) {
        Example example = new Example(Example.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("teacher_id1",userId);
        return teaEvaluationMapper.selectByExample(example);
    }

    @Override
    public int addTeaEva(TeaEvaluationEntity teaEvaluation) {
        return teaEvaluationMapper.insert(teaEvaluation);
    }
}
