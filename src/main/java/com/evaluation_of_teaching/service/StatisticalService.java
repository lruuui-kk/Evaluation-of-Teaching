package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.dto.StatisticalDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StatisticalService {

    Map statistical(int currentPage, String teaName, String dept, String courseName);

    Map statisticalStuSort(int currentPage, String teaName, String dept, String courseName, String dir);

    Map statisticalTeaSort(int currentPage, String teaName, String dept, String courseName, String dir);

}
