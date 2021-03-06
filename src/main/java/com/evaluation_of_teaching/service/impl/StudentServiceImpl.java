package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.StudentMapper;
import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.service.StudentService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    /**
     *
     * @param currentPage
     * @param name
     * @param dept
     * @return
     */
    public Map getStudents(int currentPage, String name, String dept) {
        Map map = new HashMap();
        RowBounds rowBounds =new RowBounds((currentPage-1)*10,10);
        Example example = new Example(StudentEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(name)){
            criteria.andLike("name","%"+name+"%");
        }
        if(StringUtil.isNotEmpty(dept)){
            criteria.andLike("dept","%"+dept+"%");
        }
        List<StudentEntity> studentList = studentMapper.selectByExampleAndRowBounds(example, rowBounds);
        int count = studentMapper.selectCountByExample(example);

        map.put("data",studentList);
        map.put("count",count);
        return map;
    }

    /**
     * 添加学生
     * 添加之前查一遍是否存在
     * @param student
     * @return
     */
    public int addStudent(StudentEntity student) {
        Example example = new Example(StudentEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",student.getUsername());
        List<StudentEntity> list = studentMapper.selectByExample(example);//按username字段查一下 如果有了返回0 说明该学生添加过
        if(list.isEmpty()){
            student.setPassword(student.getUsername());
            return studentMapper.addStudent(student);
        }else return 0;
    }

    public int updateStudent(StudentEntity student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    public int deleteStudent(int userId) {
        return studentMapper.deleteByPrimaryKey(userId);
    }
}
