package com.evaluation_of_teaching.service.impl;

import com.evaluation_of_teaching.dao.CourseMapper;
import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.service.CourseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Component
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    /**
     * 获取所有课程
     * @param currentPage 当前页
     * @return
     */
    public List<CourseEntity> getCourses(int currentPage) {
        RowBounds rowBounds =new RowBounds((currentPage-1)*10,10);
        return courseMapper.selectByRowBounds(null,rowBounds);
    }

    /**
     * 按学院获取课程
     * @param dept
     * @param currentPage
     * @return
     */
    public List<CourseEntity> getCourseByDpet(String dept, int currentPage) {
        RowBounds rowBounds =new RowBounds((currentPage-1)*10,10);
        Example example = new Example(CourseEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("dept",dept);
        List<CourseEntity> list = courseMapper.selectByExampleAndRowBounds(example,rowBounds);
        return list;
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
