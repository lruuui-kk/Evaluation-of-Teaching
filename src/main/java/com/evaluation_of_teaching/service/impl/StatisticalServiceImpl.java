package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.StuEvaluationMapper;
import com.evaluation_of_teaching.dao.TeaEvaluationMapper;
import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.dto.StatisticalDto;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatisticalServiceImpl implements StatisticalService {

    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StuEvaluationMapper stuEvaluationMapper;
    @Autowired
    TeaEvaluationMapper teaEvaluationMapper;

    public List<StatisticalDto> statistical(String name, String dept) {
        List<StatisticalDto> dtoList = new ArrayList<>();
        Example example = new Example(TeacherEntity.class);//通用mapper里的添加条件查询
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(name)){
            criteria.andLike("name","%"+name+"%");//判断参数添加姓名模糊查询
        }
        if(StringUtil.isNotEmpty(dept)){
            criteria.andLike("dept","%"+dept+"%");//判断参数添加学院模糊查询
        }
        List<TeacherEntity> teacherList = teacherMapper.selectByExample(example);//拿到老师信息
        if(!teacherList.isEmpty()){
            for (int i = 0; i < teacherList.size(); i++) {
                StatisticalDto dto = new StatisticalDto();
                dto.setTeaName(teacherList.get(i).getName());
                dto.setDept(teacherList.get(i).getDept());
                dto.setSex(teacherList.get(i).getSex());
                dto.setSno(teacherList.get(i).getSno());//设置老师信息到dto

                Integer teacher_id = teacherList.get(i).getTeacher_id();//拿到老师的id 去查学生评价和老师评价

                Example exampleStuEva = new Example(StuEvaluationEntity.class);
                Example.Criteria criteriaStuEva = exampleStuEva.createCriteria();
                criteriaStuEva.andEqualTo("teacher_id",teacher_id);//通用mapper的根据属性查询
                List<StuEvaluationEntity> stuEvaList = stuEvaluationMapper.selectByExample(exampleStuEva);
                if(!stuEvaList.isEmpty()){
                    Integer stuScore = 0;
                    for (int j = 0; j < stuEvaList.size(); j++) {
                        stuScore += stuEvaList.get(j).getSum();
                    }
                    int stuResult = (int)(stuScore/stuEvaList.size());//求某老师所有的学生评分均值
                    dto.setStuScore(stuResult);
                }

                Example exampleTeaEva = new Example(TeaEvaluationEntity.class);
                Example.Criteria criteriaTeaEva = exampleTeaEva.createCriteria();
                criteriaTeaEva.andEqualTo("teacher_id2",teacher_id);
                List<TeaEvaluationEntity> teaEvaList = teaEvaluationMapper.selectByExample(exampleTeaEva);
                if (!teaEvaList.isEmpty()){
                    Integer teaScore = 0;
                    for (int k = 0; k < teaEvaList.size(); k++) {
                        teaScore += teaEvaList.get(k).getSum();
                    }
                    int teaResult = (int)(teaScore/teaEvaList.size());//求某老师所有的老师评分均值
                    dto.setTeaScore(teaResult);
                }
                dtoList.add(dto);//把统计好的每个老师放进list
            }
        }
        return dtoList;
    }
}
