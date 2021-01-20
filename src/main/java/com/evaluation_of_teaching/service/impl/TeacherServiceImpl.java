package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.TeacherService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
@Component
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    /**
     *
     * @param currentPage
     * @param name
     * @param dept
     * @return
     */
    public List<TeacherEntity> getTeachers(int currentPage, String name, String dept) {
        RowBounds rowBounds =new RowBounds((currentPage-1)*10,10);
        Example example = new Example(TeacherEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(name)){
            criteria.andLike("name","%"+name+"%");
        }
        if(StringUtil.isNotEmpty(dept)){
            criteria.andLike("dept","%"+dept+"%");
        }
        return teacherMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    /**
     * 新增老师
     * 新增的时候先查询新增的用户是否存在
     * @param teacher
     * @return
     */
    public int addTeacher(TeacherEntity teacher) {
        Example example = new Example(TeacherEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",teacher.getUsername());
        List<TeacherEntity> list = teacherMapper.selectByExample(example);//按username字段查一下 如果有了返回0 说明该老师添加过
        if(list.isEmpty()){
            teacher.setPassword(teacher.getUsername());
            return teacherMapper.insert(teacher);
        }else return 0;
    }

    public int updateTeacher(TeacherEntity teacher) {
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    public int deleteTeacher(int userId) {
        return teacherMapper.deleteByPrimaryKey(userId);
    }
}
