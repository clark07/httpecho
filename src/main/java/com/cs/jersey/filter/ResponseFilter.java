package com.cs.jersey.filter;

import com.cs.bean.EchoBean;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by chensheng350 on 2017/7/5.
 */
public class ResponseFilter implements ContainerResponseFilter {
	@Override
	public void filter(ContainerRequestContext containerRequestContext,
					   ContainerResponseContext containerResponseContext) throws IOException {

		Object entity = containerResponseContext.getEntity();
		if(Objects.nonNull(entity) && entity instanceof EchoBean){
			EchoBean echoBean = (EchoBean) entity;

			echoBean.setMethod(containerRequestContext.getMethod());
		}

	}
}
