package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.CourseMapper;
import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.CourseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    /**
     * 获取课程
     * @param currentPage 当前页数 必须传
     * @param name 课程名 选择传参，可以进行模糊查询
     * @param dept 课程所属部门 选择传参，可以进行模糊查询
     * @return
     */
    public Map getCourses(int currentPage, String name, String dept) {
        Map map = new HashMap();
        RowBounds rowBounds =new RowBounds((currentPage-1)*10,10);
        Example example = new Example(CourseEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(name)){
            criteria.andLike("name","%"+name+"%");
        }
        if(StringUtil.isNotEmpty(dept)){
            criteria.andLike("dept","%"+dept+"%");
        }
        List<CourseEntity> courseList = courseMapper.selectByExampleAndRowBounds(example, rowBounds);
        int count = courseMapper.selectCountByExample(example);
        map.put("data",courseList);
        map.put("count",count);
        return map;
    }


    /**
     * 添加课程
     * 添加之前查下这个名字的课程是否存在
     * @param course
     * @return
     */
    public int addCourse(CourseEntity course) {
        Example example = new Example(CourseEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",course.getName());
        List<CourseEntity> list = courseMapper.selectByExample(example);//按name字段查一下 如果有了返回0 说明该课程添加过
        if(list.isEmpty()){
            return courseMapper.insert(course);
        }else return 0;
    }

    public int updateCourse(CourseEntity course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    public int deleteCourse(int courseId) {
        return courseMapper.deleteByPrimaryKey(courseId);
    }
}
