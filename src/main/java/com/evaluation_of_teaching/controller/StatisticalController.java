package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.dto.StatisticalDto;
import com.evaluation_of_teaching.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticalController {

    @Autowired
    StatisticalService statisticalService;

    @RequestMapping(path = "/statistical")
    List<StatisticalDto> statistical(int currentPage, String teaName, String dept, String courseName){
        return statisticalService.statistical(currentPage,teaName,dept,courseName);
    }

    @RequestMapping(path = "/statisticalStuSort")
    List<StatisticalDto> statisticalStuSort(int currentPage, String teaName, String dept, String courseName, String dir){
        return statisticalService.statisticalStuSort(currentPage,teaName,dept,courseName,dir);
    }

    @RequestMapping(path = "/statisticalTeaSort")
    List<StatisticalDto> statisticalTeaSort(int currentPage, String teaName, String dept, String courseName, String dir){
        return statisticalService.statisticalTeaSort(currentPage,teaName,dept,courseName,dir);
    }
}
