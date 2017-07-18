package com.cs.util;

/**
 * Created by chensheng350 on 2017/7/13.
 */
public class EmojiQQBean {

	/**
	 * qq字符表情  默认使用
	 *   /::)
	 */
	private String qqCode;
	/**
	 * 中括号  备用
	 * [微笑]
	 */
	private String qqBracketsCode;
	/**
	 *中文转义  备用
	 * /微笑
	 */
	private String qqEscapedCode;


	/**
	 * emoji代码
	 * U+1F60A
	 */
	private String emojiCode;


	/**
	 * qq表情描述
	 */
	private String description;

	public EmojiQQBean() {
	}

	public EmojiQQBean(String qqCode, String emojiCode, String description) {
		this.qqCode = qqCode;
		this.emojiCode = emojiCode;
		this.description = description;
	}

	public String getQqCode() {
		return qqCode;
	}

	public String getQqBracketsCode() {
		return qqBracketsCode;
	}

	public String getQqEscapedCode() {
		return qqEscapedCode;
	}

	public String getEmojiCode() {
		return emojiCode;
	}

	public String getDescription() {
		return description;
	}
}
