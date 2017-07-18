package com.cs.emoji;

import com.cs.util.EmojiUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chensheng350 on 2017/7/13.
 */
public class EmojiUtilTest {

	@Test
	public void testConvertQQ2Emoji1(){
		String qqContent = "我是一个普通文本,不包含QQ表情";
		String content = EmojiUtil.convertQQ2Emoji(qqContent);
		Assert.assertEquals(content, qqContent);
	}
	@Test
	public void testConvertQQ2Emoji2(){
		String qqContent = String.format("我是一个包含QQ表情的文本 表情微笑:%s", "/::)");
		String validateContent = String.format("我是一个包含QQ表情的文本 表情微笑:%s","\uD83D\uDE00");
		String content = EmojiUtil.convertQQ2Emoji(qqContent);
		Assert.assertEquals(content, validateContent);
	}
	@Test
	public void testConvertQQ2Emoji3(){
		String qqContent = String.format("我是一个包含QQ表情的文本 表情糟糕:%s", "/:&-(");
		String validateContent = String.format("我是一个包含QQ表情的文本 表情糟糕:%s", "[糟糕]");
		String content = EmojiUtil.convertQQ2Emoji(qqContent);
		Assert.assertEquals(content, validateContent);
	}
	@Test
	public void testConvertQQ2Emoji4(){
		String qqContent = String.format("我是一个包含特殊字符串的文本 %s", "/:&-s(ss)");
		String validateContent = String.format("我是一个包含特殊字符串的文本 %s", "/:&-s(ss)");
		String content = EmojiUtil.convertQQ2Emoji(qqContent);
		Assert.assertEquals(content, validateContent);
	}
	@Test
	public void testConvertQQ2Emoji5(){
		String qqContent = String.format("我是一个同时包含QQ表情和emoji表情的文本 qq表情调皮:%s emoji表情亲脸:%s", "/::P", "\uD83D\uDE17");
		String validateContent = String.format("我是一个同时包含QQ表情和emoji表情的文本 qq表情调皮:%s emoji表情亲脸:%s", "\uD83D\uDE09", "\uD83D\uDE17");
		String content = EmojiUtil.convertQQ2Emoji(qqContent);
		Assert.assertEquals(content, validateContent);
	}


	@Test
	public void testConvertEmoji2QQ1(){
		String qqContent = "我是一个普通文本,不包含emoji表情";
		String content = EmojiUtil.convertEmoji2QQ(qqContent);
		Assert.assertEquals(content, qqContent);
	}
	@Test
	public void testConvertEmoji2QQ2(){
		String qqContent = String.format("我是一个包含emoji表情的文本 表情微笑:%s", "\uD83D\uDE00");
		String validateContent = String.format("我是一个包含emoji表情的文本 表情微笑:%s","/::)");
		String content = EmojiUtil.convertEmoji2QQ(qqContent);
		Assert.assertEquals(content, validateContent);
	}
	@Test
	public void testConvertEmoji2QQ3(){
		String qqContent = String.format("我是一个包含emoji表情的文本 表情:%s", "\uD83E\uDD13");
		String validateContent = String.format("我是一个包含emoji表情的文本 表情:%s", "[em]nerd face[/em]");
		String content = EmojiUtil.convertEmoji2QQ(qqContent);
		Assert.assertEquals(content, validateContent);
	}
	@Test
	public void testConvertEmoji2QQ4(){
		String qqContent = String.format("我是一个包含QQ表情的文本 表情糟糕:%s", "/:&-(");
		String validateContent = String.format("我是一个包含QQ表情的文本 表情糟糕:%s", "/:&-(");
		String content = EmojiUtil.convertEmoji2QQ(qqContent);
		Assert.assertEquals(content, validateContent);
	}
	@Test
	public void testConvertEmoji2QQ5(){
		String qqContent = String.format("我是一个同时包含QQ表情和emoji表情的文本 qq表情调皮:%s emoji表情亲脸:%s", "/::P", "\uD83D\uDE00");
		String validateContent = String.format("我是一个同时包含QQ表情和emoji表情的文本 qq表情调皮:%s emoji表情亲脸:%s", "/::P", "/::)");
		String content = EmojiUtil.convertEmoji2QQ(qqContent);
		Assert.assertEquals(content, validateContent);
	}
}
