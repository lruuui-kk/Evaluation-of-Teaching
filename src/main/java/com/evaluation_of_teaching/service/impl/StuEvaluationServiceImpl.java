package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.CourseMapper;
import com.evaluation_of_teaching.dao.StuEvaluationMapper;
import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.dto.courseTeacherDto;
import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.StuEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
public class StuEvaluationServiceImpl implements StuEvaluationService {

    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StuEvaluationMapper stuEvaluationMapper;

    public List<StuEvaluationEntity> getStuEvaList(int userId) {
        Example example = new Example(StuEvaluationEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("student_id",userId);
        return stuEvaluationMapper.selectByExample(example);
    }

    public courseTeacherDto queryStuEva(int userId, int courseId) {
        Example example = new Example(StuEvaluationEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("student_id",userId);
        criteria.andEqualTo("course_id",courseId);
        List<StuEvaluationEntity> stuEvas = stuEvaluationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(stuEvas)){
            TeacherEntity teacherEntity = teacherMapper.selectByPrimaryKey(userId);
            CourseEntity courseEntity = courseMapper.selectByPrimaryKey(courseId);
            courseTeacherDto dto = new courseTeacherDto();
            dto.setTeacher(teacherEntity);
            dto.setCourse(courseEntity);
            return dto;
        }
        return null;
    }

    public int addStuEva(StuEvaluationEntity stuEvaluation) {
        stuEvaluation.setSum(
                stuEvaluation.getStr1()+
                stuEvaluation.getStr2()+
                stuEvaluation.getStr3()+
                stuEvaluation.getStr4()+
                stuEvaluation.getStr5()+
                stuEvaluation.getStr6()
        );
        return stuEvaluationMapper.insert(stuEvaluation);
    }
}
