package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.CourseMapper;
import com.evaluation_of_teaching.dao.StuEvaluationMapper;
import com.evaluation_of_teaching.dao.TeaEvaluationMapper;
import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.dto.StatisticalDto;
import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.StatisticalService;
import org.apache.ibatis.session.RowBounds;
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
    CourseMapper courseMapper;
    @Autowired
    StuEvaluationMapper stuEvaluationMapper;
    @Autowired
    TeaEvaluationMapper teaEvaluationMapper;

    public List<StatisticalDto> statistical(int currentPage, String teaName, String dept, String courseName) {
        List<StatisticalDto> dtoList = new ArrayList<>();
        Example example = new Example(CourseEntity.class);//通用mapper里的添加条件查询
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(teaName)){
            criteria.andLike("teacher_name","%"+teaName+"%");//判断参数添加老师姓名模糊查询
        }
        if(StringUtil.isNotEmpty(dept)){
            criteria.andLike("dept","%"+dept+"%");//判断参数添加课程所属学院模糊查询
        }
        if(StringUtil.isNotEmpty(courseName)){
            criteria.andLike("courseName","%"+courseName+"%");//判断参数添加课程名模糊查询
        }

        RowBounds rowBounds =new RowBounds((currentPage-1)*10,10);
        List<CourseEntity> courseList = courseMapper.selectByExampleAndRowBounds(example,rowBounds);//拿到课程信息

        if(!courseList.isEmpty()){
            for (int i = 0; i < courseList.size(); i++) {
                StatisticalDto dto = new StatisticalDto();
                dto.setTeaName(courseList.get(i).getTeacher_name());
                dto.setCourseId(courseList.get(i).getCourse_id());
                dto.setCourseName(courseList.get(i).getName());
                dto.setDept(courseList.get(i).getDept());
                dto.setNum(courseList.get(i).getNum());//设置课程信息到dto

                Integer teacher_id = courseList.get(i).getTeacher_id();//拿到老师的id 去查学生评价和老师评价
                Integer course_id = courseList.get(i).getCourse_id();//拿到课程的id 去查学生评价

                Example exampleStuEva = new Example(StuEvaluationEntity.class);
                Example.Criteria criteriaStuEva = exampleStuEva.createCriteria();
                criteriaStuEva.andEqualTo("course_id",course_id);
                criteriaStuEva.andEqualTo("teacher_id",teacher_id);//通用mapper的根据属性查询
                List<StuEvaluationEntity> stuEvaList = stuEvaluationMapper.selectByExample(exampleStuEva);
                if(!stuEvaList.isEmpty()){
                    Integer stuScore = 0;
                    for (int j = 0; j < stuEvaList.size(); j++) {
                        stuScore += stuEvaList.get(j).getSum();
                    }
                    int stuResult = (int)(stuScore/stuEvaList.size());//求某老师的某课程所有的学生评分均值
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
