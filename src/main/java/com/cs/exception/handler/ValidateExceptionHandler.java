package com.cs.exception.handler;

import com.cs.CodeType;
import com.cs.bean.ReturnBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by chensheng350 on 2017/7/7.
 */
@Provider
public class ValidateExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

	private final static Logger logger = Logger.getLogger(ValidateExceptionHandler.class);

	@Override
	public Response toResponse(ConstraintViolationException e) {
		ReturnBean returnBean = new ReturnBean();
		returnBean.setCode(CodeType.INVALID_PARAM.getValue());
		String message = "参数校验失败:" + StringUtils.join(Optional.of(e.getConstraintViolations()).get().stream().map(c -> String
				.format("param:%s->validate result:%s", c.getInvalidValue(), c.getMessage())).collect(Collectors.toList()), ";");
		returnBean.setMessage(message);

		logger.error(message, e);
		return Response.ok(returnBean).type(MediaType.APPLICATION_JSON).build();
	}
}
