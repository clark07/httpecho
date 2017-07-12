package com.cs.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chensheng350 on 2017/7/5.
 */
@NoArgsConstructor
@Data
public class EchoBean {

	private Map<String, String> args = new LinkedHashMap<>();
	private String data;
	private Map<String, String> files;;
	private Map<String, String> form;
	private Map<String, String> headers = new TreeMap<>();
	private String json;
	private String origin;
	private String url;
	private String method;

}
