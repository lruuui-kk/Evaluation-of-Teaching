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
    List<StatisticalDto> statistical(String name, String dept){
        return statisticalService.statistical(name,dept);
    }
}
