package com.biqi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.biqi.model.User;
import com.common.mybatis.MyMapper;


@Mapper
public interface UserDao extends MyMapper<User> {
	

    @Select("SELECT count(*) FROM User ")
    Integer countUser();


    int countUser2();
    

}
