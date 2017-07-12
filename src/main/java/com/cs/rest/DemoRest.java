package com.cs.rest;

import com.cs.bean.EchoBean;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;

/**
 * Created by chensheng350 on 2017/7/5.
 */

@Component
@Path("/")
public class DemoRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@Context HttpServletRequest request){
		EchoBean echoBean = buildBaseInfo(request);
		return Response.ok(echoBean).build();
	}

	private EchoBean buildBaseInfo(@Context HttpServletRequest request) {
		EchoBean echoBean = new EchoBean();

		Enumeration<String> headerNames = request.getHeaderNames();

		while(headerNames.hasMoreElements()){
			String headerKey = headerNames.nextElement();

			echoBean.getHeaders().put(StringUtils.capitalize(headerKey), request.getHeader(headerKey));
		}

		echoBean.setOrigin(request.getRemoteHost());
		echoBean.setUrl(request.getRequestURL().toString());

		Map<String, String[]> parameterMap = request.getParameterMap();
		if(MapUtils.isNotEmpty(parameterMap)){
			parameterMap.forEach((k, v)->{
				echoBean.getArgs().put(k, Objects.isNull(v)?"":v[0]);
			});
		}


		return echoBean;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(@Context HttpServletRequest request, String data){
		EchoBean echoBean = buildBaseInfo(request);

		if(ServletFileUpload.isMultipartContent(request)){

			ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());


		}

		String contentType = request.getContentType();

		System.out.println(contentType);
		System.out.println("-------------------------------");
	System.out.println(data);


		return Response.ok(echoBean).build();
	}

}
