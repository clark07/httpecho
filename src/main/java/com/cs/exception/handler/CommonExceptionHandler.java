package com.cs.exception.handler;

import com.cs.CodeType;
import com.cs.bean.ReturnBean;
import org.apache.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by chensheng350 on 2017/7/7.
 */
@Provider
public class CommonExceptionHandler implements ExceptionMapper<Throwable> {

	private final static Logger logger = org.apache.log4j.Logger.getLogger(CommonExceptionHandler.class);

	@Override
	public Response toResponse(Throwable e) {
		ReturnBean returnBean = new ReturnBean();
		returnBean.setCode(CodeType.SYS_ERROR.getValue());
		returnBean.setMessage(e.getMessage());
		logger.error("exception!", e);

		return Response.ok(returnBean).type(MediaType.APPLICATION_JSON).build();
	}


	    public static void main(String[] args) throws Exception{


/*

		byte[] bs = new byte[]{-16,-97,-104,-92};
		System.out.println(bs);


			String x = "\ud83d\ude24";
			System.out.println(new String(x.getBytes(), "UTF-8"));

		System.out.println("\uD83D\uDE24".replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*"));

		//"[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]"

		System.out.println("\uF09F\u9881");
		System.out.println("\ud800\udc00");
		System.out.println("\uD83D\uDE04");

			System.out.println(new String("你好呀".getBytes("UTF-8"), "UTF-16"));
			System.out.println(new String("".getBytes("UTF-8")));


			System.out.println(Character.isLetter(0x1F60));

			String s = EmojiParser
					.parseToUnicode("An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!");*/

/*			String myString = "U+2600";
			char[] chars = Character.toChars(Integer.parseInt(myString.substring(2), 16));
			System.out.print(chars);*/
		}
}
