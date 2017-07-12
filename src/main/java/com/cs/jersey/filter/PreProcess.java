package com.cs.jersey.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import java.io.IOException;

/**
 * Created by chensheng350 on 2017/7/5.
 */
@PreMatching
public class PreProcess implements ContainerRequestFilter {
	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
		String method = containerRequestContext.getMethod();

	}
}
