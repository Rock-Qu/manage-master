package com.biqi.service;

import static com.common.check.CheckUtil.notNull;

import com.common.util.MyToken;
import com.common.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biqi.dao.UserDao;
import com.biqi.dto.LoginDto;
import com.biqi.dto.UserDto;
import com.biqi.model.User;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	public UserDto login(HttpSession session, LoginDto loginDto) {
		// TODO 校验logintime sign等
		User user = User.builder()
						.name(loginDto.getUsername())
						.password(loginDto.getPassword())
						.build();
		user = userDao.selectOne(user);
		notNull(user, "The username or password is incorrect");
		String Token = MyToken.getToken(loginDto);
		UserDto userDto = UserDto.builder()
				.name(user.getName())
				.phone(user.getPhone())
				.token(Token)
				.build();
		//需要将用户信息存放到静态类中，或者redis中
		session.setAttribute(UserUtil.KEY_USER, user.getName());
		return userDto;
	}


	public Boolean loginOut(LoginDto loginDto) {
		return null;
	}
}

