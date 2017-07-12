package com.cs;

import lombok.Getter;

/**
 * Created by chensheng350 on 2017/7/10.
 */
@Getter
public enum CodeType {

	SUCC(0, "成功"),
	FAIL(1, "失败"),
	INVALID_PARAM(1000, "参数错误"),
	SYS_ERROR(9999, "系统错误"),
	;

	private int value;
	private String description;

	private CodeType(int value, String description) {
		this.value = value;
		this.description = description;
	}
}
