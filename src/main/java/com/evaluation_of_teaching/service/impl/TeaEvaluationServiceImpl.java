package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.TeaEvaluationMapper;
import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.dto.courseTeacherDto;
import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.TeaEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Component
public class TeaEvaluationServiceImpl implements TeaEvaluationService {

    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    TeaEvaluationMapper teaEvaluationMapper;

    public List<TeaEvaluationEntity> getTeaEvaList(int userId) {
        Example example = new Example(TeaEvaluationEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("teacher_id1",userId);
        return teaEvaluationMapper.selectByExample(example);
    }

    @Override
    public TeacherEntity queryTeaEva(int id1, int id2) {
        Example example = new Example(TeaEvaluationEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("teacher_id1",id1);
        criteria.andEqualTo("teacher_id2",id2);
        List<TeaEvaluationEntity> teaEvas = teaEvaluationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(teaEvas)){
            TeacherEntity teacherEntity = teacherMapper.selectByPrimaryKey(id2);//id2是被评老师 所以返回被评老师的信息
            return teacherEntity;
        }
        return null;
    }

    public int addTeaEva(TeaEvaluationEntity teaEvaluation) {
        return teaEvaluationMapper.insert(teaEvaluation);
    }
}
