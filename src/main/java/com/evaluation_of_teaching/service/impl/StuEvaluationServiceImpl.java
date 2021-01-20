package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.CourseMapper;
import com.evaluation_of_teaching.dao.StuEvaluationMapper;
import com.evaluation_of_teaching.dao.StudentMapper;
import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.dto.StuEvaluationDto;
import com.evaluation_of_teaching.dto.courseTeacherDto;
import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.model.StuEvaluationEntity;
import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.StuEvaluationService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Component
public class StuEvaluationServiceImpl implements StuEvaluationService {

    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StudentMapper studentMapper;
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

    /**
     * 查询所有学生对所有课程的评价（用于管理员查看学生评价）
     * @param currentPage
     * @return
     */
    public List<StuEvaluationDto> queryAllStuEva(int currentPage) {
        List<StuEvaluationDto> dtoList = new ArrayList<>();
        Example example = new Example(StuEvaluationEntity.class);//通用mapper里的添加条件查询
        RowBounds rowBounds =new RowBounds((currentPage-1)*10,10);
        
        List<StuEvaluationEntity> stuEvaList = stuEvaluationMapper.selectByExampleAndRowBounds(example,rowBounds);
        if(!stuEvaList.isEmpty()){
            for (int i = 0; i < stuEvaList.size(); i++) {
                StuEvaluationDto dto = new StuEvaluationDto();
                Integer stu_id = stuEvaList.get(i).getStudent_id();
                Integer tea_id = stuEvaList.get(i).getTeacher_id();
                Integer cou_id = stuEvaList.get(i).getCourse_id();
                StudentEntity studentPart = studentMapper.selectByPrimaryKey(stu_id);
                TeacherEntity teacherPart = teacherMapper.selectByPrimaryKey(tea_id);
                CourseEntity coursePart = courseMapper.selectByPrimaryKey(cou_id);
                dto.setStuEvaluation(stuEvaList.get(i));
                dto.setStudent(studentPart);
                dto.setTeacher(teacherPart);
                dto.setCourse(coursePart);

                dtoList.add(dto);//把查出来的每个部分信息放进list
            }
        }
        return dtoList;
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
