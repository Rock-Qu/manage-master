package com.common.constant;


public enum ReCode {
	

	SUCCESS("SUCCESS",0),

	FAIL_UNKNOWN_ERROR("FAIL_UNKNOWN_ERROR",-1),

	FAIL_UNLOGIN_ERROR("FAIL_UNLOGIN_ERROR",4000),

	FAIL_SERVER_ERROR("FAIL_SERVER_ERROR",4100),

	FAIL_UNCHECK_ERROR("FAIL_UNCHECK_ERROR",4200),

	FAIL_PARAMETER_ERROR("FAIL_PARAMETER_ERROR",4300),

	FAIL_JSON_ERROR("FAIL_JSON_ERROR",4301);
	
	private String name;
	
	private int code;

	private ReCode(String codeNmae, int code) {
		this.name = codeNmae;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	
	

}
