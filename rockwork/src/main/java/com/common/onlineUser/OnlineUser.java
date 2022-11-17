package com.common.onlineUser;

import org.springframework.beans.factory.annotation.Value;


public class OnlineUser {
	

	@Value("${mqtt.onlinetpye}")
	private String onlinetpye;
	
	private static volatile OnlineUserInterFace managerUsers;
	
	public OnlineUserInterFace getOnlineUser() {
		if (null == managerUsers) {
			if (onlinetpye.equals("java")) {
				managerUsers = new JavaOnlineUsers();
			}else {
				managerUsers = new RedisOnlineUsers();
			}
			return managerUsers;
		}
		else {
			return managerUsers;
		}
	}

}
