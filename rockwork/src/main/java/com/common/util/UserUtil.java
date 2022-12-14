package com.common.util;

import java.util.Locale;

import com.common.exception.UnloginException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;


@Slf4j
public class UserUtil {

	private final static ThreadLocal<String> tlUser = new ThreadLocal<String>();

	private final static ThreadLocal<Locale> tlLocale = new ThreadLocal<Locale>() {
		protected Locale initialValue() {
			// 语言的默认值
			return Locale.CHINESE;
		};
	};

	public static final String KEY_LANG = "lang";

	public static final String KEY_USER = "user";

	public static void setUser(String userid) {
		tlUser.set(userid);
		// 把用户信息放到log4j
		MDC.put(KEY_USER, userid);
	}


	public static String getUserIfLogin() {
		return tlUser.get();
	}


	public static String getUser() {
		String user = tlUser.get();

		if (user == null) {
			throw new UnloginException();
		}

		return user;
	}

	public static void setLocale(String locale) {
		setLocale(new Locale(locale));
	}

	public static void setLocale(Locale locale) {
		tlLocale.set(locale);
	}

	public static Locale getLocale() {
		return tlLocale.get();
	}

	public static void clearAllUserInfo() {
		tlUser.remove();
		tlLocale.remove();

		MDC.remove(KEY_USER);
	}
}
