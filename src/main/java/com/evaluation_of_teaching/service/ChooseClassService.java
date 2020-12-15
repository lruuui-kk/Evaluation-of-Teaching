package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.model.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChooseClassService {

    List<StudentEntity> queryChooseListByUser(String userId);

    int addChooseClass(String userId,String courseId);

    int deleteChooseClass(String userId,String courseId);
}
