package com.cs.rest;

import com.cs.bean.ValidBean;
import com.cs.util.GsonUtil;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by chensheng350 on 2017/7/7.
 */
@Path("/validate")
public class ValidateRest {


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String post(@Valid @NotNull ValidBean validBean){
		return GsonUtil.toJson(validBean);
	}
	@Path("/exception")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String exception(@Valid ValidBean validBean){
		throw new RuntimeException("test");
	}


}
