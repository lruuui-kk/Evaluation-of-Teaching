package com.evaluation_of_teaching.dao;

import com.evaluation_of_teaching.model.ChooseClassEntity;
import com.evaluation_of_teaching.model.StudentEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface ChooseClassMapper extends Mapper<ChooseClassEntity> {

    List<StudentEntity> queryChooseListByUser(int userId);

    int deleteChooseClass(int userId,int courseId);
}
