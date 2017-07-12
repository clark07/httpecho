package com.cs.emoji;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by chensheng350 on 2017/7/12.
 */


public class EmojiDemo {



	@Test
	public void showEmoji() throws Exception{

		Pattern p_emoji_line = Pattern.compile("^(\\d{1,4})\\t(U\\+\\w{4,5}(\\sU\\+\\w{4,5})*)[\\s\\S]*?[\\t\\s](\\w[\\s\\S]+)$");

		Path emojiPath = Paths.get("C:\\Users\\chensheng350\\Desktop\\emoji file.txt");

		//Set<String> ss = new TreeSet<>();
		//IntStream.rangeClosed(1,2623).forEach(i->ss.add(String.valueOf(i)));
		Files.lines(emojiPath).forEach(line->{
			Matcher m_line = p_emoji_line.matcher(line);
			if(m_line.find()){
				String sequence = m_line.group(1);
				String code = m_line.group(2);
				String description = m_line.group(4);

				 List<String> collect = Arrays.stream(code.split(" ")).map(s -> {
					int i = Integer.parseInt(s.substring(2), 16);
					return new String(Character.toChars(i));
				}).collect(Collectors.toList());

				//System.out.println(String.format("%s-->%s-->%s", sequence, StringUtils.join(collect, ""), description));
				//ss.remove( m_line.group(1));
			}
		});

		//[em]e187[/aini]   爱你
		Pattern p_qq_line = Pattern.compile("^\\[em\\](e\\d{3})\\[(/\\w+)\\]\\s+(\\S+)$");

		Path qqPath = Paths.get("C:\\Users\\chensheng350\\Desktop\\qq.txt");

		//Set<String> ss = new TreeSet<>();
		//IntStream.rangeClosed(1,2623).forEach(i->ss.add(String.valueOf(i)));
		Files.lines(qqPath).forEach(line->{
			Matcher m_qq_line = p_qq_line.matcher(line);
			if(m_qq_line.find()){
				String code1 = m_qq_line.group(1);
				String code2 = m_qq_line.group(2);
				String code3 = m_qq_line.group(3);

				System.out.println(String.format("%s-->%s-->%s", code1, code2, code3));
				//ss.remove( m_line.group(1));
			}
		});


		//System.out.println(ss);

	}

}
