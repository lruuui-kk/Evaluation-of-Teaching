package com.evaluation_of_teaching.dao;

import com.evaluation_of_teaching.dto.StatisticalDto;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface StatisticalMapper extends Mapper<StatisticalDto> {
}
