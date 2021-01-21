package com.evaluation_of_teaching.service;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ChooseClassService {

    Map queryChooseListByUser(int currentPage, int userId);

    int addChooseClass(int userId,int courseId);

    int deleteChooseClass(int userId,int courseId);
}
