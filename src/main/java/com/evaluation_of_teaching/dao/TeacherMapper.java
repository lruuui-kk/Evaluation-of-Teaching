package com.evaluation_of_teaching.dao;


import com.evaluation_of_teaching.model.TeacherEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface TeacherMapper extends Mapper<TeacherEntity>{

    @Select("select * from teacher where username = #{username}")
    TeacherEntity getTeacherByUsername(String username);
}
