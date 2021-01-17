package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.CourseMapper;
import com.evaluation_of_teaching.dao.StuEvaluationMapper;
import com.evaluation_of_teaching.dao.TeaEvaluationMapper;
import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.dto.stuEvaDto;
import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.TeaEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
@Component
public class TeaEvaluationServiceImpl implements TeaEvaluationService {

    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    TeaEvaluationMapper teaEvaluationMapper;
    @Autowired
    StuEvaluationMapper stuEvaluationMapper;
    @Autowired
    CourseMapper courseMapper;

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
        teaEvaluation.setSum(
                teaEvaluation.getStr1()+
                teaEvaluation.getStr2()+
                teaEvaluation.getStr3()+
                teaEvaluation.getStr4()+
                teaEvaluation.getStr5()+
                teaEvaluation.getStr6()
        );
        return teaEvaluationMapper.insert(teaEvaluation);
    }

    public List<stuEvaDto> queryStuEvaById(int id){
        List<stuEvaDto> dtoList = new ArrayList<>();
        Example example = new Example(StuEvaluationEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("teacher_id",id);
        List<StuEvaluationEntity> stuEvaList = stuEvaluationMapper.selectByExample(example);
        if(!stuEvaList.isEmpty()) {
            for (int i = 0; i < stuEvaList.size(); i++) {
                stuEvaDto dto = new stuEvaDto();
                dto.setStudent_id(stuEvaList.get(i).getStudent_id());
                dto.setCourse_id(stuEvaList.get(i).getCourse_id());
                dto.setStr1(stuEvaList.get(i).getStr1());
                dto.setStr2(stuEvaList.get(i).getStr2());
                dto.setStr2(stuEvaList.get(i).getStr2());
                dto.setStr3(stuEvaList.get(i).getStr3());
                dto.setStr4(stuEvaList.get(i).getStr4());
                dto.setStr5(stuEvaList.get(i).getStr5());
                dto.setStr6(stuEvaList.get(i).getStr6());
                dto.setSum(stuEvaList.get(i).getSum());
                dto.setContent(stuEvaList.get(i).getContent());//设置学生评价信息到dto

                Integer course_id = stuEvaList.get(i).getCourse_id();
                CourseEntity courseEntity = courseMapper.selectByPrimaryKey(course_id);//查课程

                dto.setCourse_name(courseEntity.getName());
                dto.setDept(courseEntity.getDept());
                dto.setTerm(courseEntity.getTerm());
                dto.setStart_time(courseEntity.getStart_time());
                dto.setEnd_time(courseEntity.getEnd_time());
                dto.setPlace(courseEntity.getPlace());
                dto.setNum(courseEntity.getNum());
                dto.setTeacher_name(courseEntity.getTeacher_name());//再把课程信息加到dto

                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    public List<TeaEvaluationEntity> queryTeaEvaById(int id){
        Example example = new Example(TeaEvaluationEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("teacher_id2",id);
        return teaEvaluationMapper.selectByExample(example);
    }
}
