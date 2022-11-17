package com.biqi.dao;

import com.biqi.model.RoleToPermission;
import com.biqi.model.UserToRole;
import com.common.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserToRoleDao extends MyMapper<UserToRole> {
	
}
