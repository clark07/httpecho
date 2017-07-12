package com.cs.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by chensheng350 on 2017/7/7.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidBean {


	/**
	 * @Null
	验证对象是否为空
	 @NotNull
	 验证对象是否为非空
	 @AssertTrue
	 验证 Boolean 对象是否为 true
	 @AssertFalse
	 验证 Boolean 对象是否为 false
	 @Min
	 验证 Number 和 String 对象是否大等于指定的值
	 @Max
	 验证 Number 和 String 对象是否小等于指定的值
	 @DecimalMin
	 验证 Number 和 String 对象是否大等于指定的值，小数存在精度
	 @DecimalMax
	 验证 Number 和 String 对象是否小等于指定的值，小数存在精度
	 @Size
	 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内
	 @Digits
	 验证 Number 和 String 的构成是否合法
	 @Past
	 验证 Date 和 Calendar 对象是否在当前时间之前
	 @Future
	 验证 Date 和 Calendar 对象是否在当前时间之后
	 @Pattern
	 验证 String 对象是否符合正则表达式的规则
	 */

	@NotNull(message = "name 不允许为空")
	@Pattern(regexp = "\\w{2}\\d{2}", message = "name regexp{regexp}")
	private String name;

	@Max(value = 99, message = "age must < 100")
	@Min(value = 1, message = "age must > 0")
	private int age;
}
