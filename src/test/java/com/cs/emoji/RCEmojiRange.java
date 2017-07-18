package com.cs.emoji;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chensheng350 on 2017/7/17.
 */
public class RCEmojiRange {


	    public static void main(String[] args) throws Exception{

			Path path = Paths.get("C:\\Users\\chensheng350\\Desktop\\融云支持的emoj");

			Set<String> ss = new HashSet<>();
			Files.list(path).filter(p->p.getFileName().toString().endsWith("png")).forEach(p->{
				String fileName = p.getFileName().toString().split("\\.")[0].replaceFirst("u", "U+").toUpperCase();
				ss.add(String.format("\"%s\"", fileName));
				//System.out.println(fileName);
			});
			System.out.println(ss);


		}

}
