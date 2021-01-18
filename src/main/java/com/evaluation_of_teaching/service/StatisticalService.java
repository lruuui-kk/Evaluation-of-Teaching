package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.dto.StatisticalDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticalService {

    List<StatisticalDto> statistical(int currentPage, String teaName, String dept, String courseName);

    List<StatisticalDto> statisticalStuSort(int currentPage, String teaName, String dept, String courseName, String dir);

    List<StatisticalDto> statisticalTeaSort(int currentPage, String teaName, String dept, String courseName, String dir);

}
