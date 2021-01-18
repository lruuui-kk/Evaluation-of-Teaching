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

import java.util.List;
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
    public List<CourseEntity> getCourses(int currentPage, String name, String dept) {
        RowBounds rowBounds =new RowBounds((currentPage-1)*10,10);
        Example example = new Example(CourseEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(name)){
            criteria.andLike("name","%"+name+"%");
        }
        if(StringUtil.isNotEmpty(dept)){
            criteria.andLike("dept","%"+dept+"%");
        }
        return courseMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    /**
     * 按学院获取课程
     * 上面接口已经实现了这个功能 此接口应该废弃
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
