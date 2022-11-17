package com.common.onlineUser;

import java.util.List;

import com.biqi.dto.UserOnline;


public interface OnlineUserInterFace {
	

	void init();
	
	

	UserOnline getUserOnline(String token);
	

	String addUser(UserOnline user);
	

	boolean removeUser(String token);

	int countUsers();

	List<UserOnline> list();
	
	
	
	
	

}
