package com.evaluation_of_teaching.dao;

import com.evaluation_of_teaching.model.TeaEvaluationEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface TeaEvaluationMapper extends Mapper<TeaEvaluationEntity> {
}
