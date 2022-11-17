package com.common.check;

import com.common.constant.ReCode;
import com.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;


@Slf4j
public class CheckUtil {


	public static final int FAIL_SERVER_ERROR = ReCode.FAIL_SERVER_ERROR.getCode();



    public static void hasErrors(BindingResult bindingResult){
		StringBuilder sb = new StringBuilder();
		if(bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			errors.forEach(item->sb.append(item.getDefaultMessage()+";"));
			fail(ReCode.FAIL_PARAMETER_ERROR.getCode(),sb.toString());
		}
	};


	public static void check(boolean condition, String msg) {
		if (!condition) {
			fail(FAIL_SERVER_ERROR,msg);
		}
	}
	

	public static void check(boolean condition,Integer retcode, String msg) {
		if (!condition) {
			fail(retcode,msg);
		}
	}


	public static void notEmpty(String str, String msg) {
		if (null == str || str.isEmpty()) {
			fail(FAIL_SERVER_ERROR,msg);
		}
	}
	

	public static void notNull(Object obj, String msg) {
		if (null == obj) {
			fail(FAIL_SERVER_ERROR,msg);
		}
	}

	private static void fail(Integer retcode,String msg) {
		log.error(msg);
		throw new ServiceException(retcode, msg);
	}
	
}

