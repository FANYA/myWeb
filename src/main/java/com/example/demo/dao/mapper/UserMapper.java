package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(@Param("host") String host, @Param("user") String user);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("host") String host, @Param("user") String user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}