package com.evaluation_of_teaching.service;

import com.evaluation_of_teaching.dto.StatisticalDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticalService {

    List<StatisticalDto> statistical(String name, String dept);

}
