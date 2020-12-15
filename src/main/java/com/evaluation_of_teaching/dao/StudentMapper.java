package com.evaluation_of_teaching.dao;

import com.evaluation_of_teaching.model.StudentEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper extends tk.mybatis.mapper.common.Mapper<StudentEntity> {

    @Select("select * from student")
    List<StudentEntity> getStudents();

    @Select("select * from student where username = #{username}")
    StudentEntity getStudentByUsername(String username);

    @Insert("insert into student(student_id,username,password,name,sno,sex,dept,stu_class) values(#{student_id},#{username},#{password},#{name},#{sno},#{sex},#{dept},#{stu_class})")
    int addStudent(StudentEntity studentEntity);
}
