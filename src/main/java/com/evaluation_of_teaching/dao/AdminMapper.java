package com.evaluation_of_teaching.dao;

import com.evaluation_of_teaching.model.AdminEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface AdminMapper extends Mapper<AdminEntity> {
    @Select("select * from admin where username = #{username}")
    AdminEntity getAdminByUsername(String username);
}
