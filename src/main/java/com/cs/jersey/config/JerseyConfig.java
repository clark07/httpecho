package com.cs.jersey.config;

import com.cs.jersey.filter.PreProcess;
import com.cs.jersey.filter.ResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;

/**
 * Created by chensheng350 on 2017/7/5.
 */
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		// Now you can expect validation errors to be sent to the client.
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		// @ValidateOnExecution annotations on subclasses won't cause errors.
		property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
		register(PreProcess.class);
		register(ResponseFilter.class);
		register(ValidationConfigurationContextResolver.class);
		packages("com.cs.rest");
		packages("com.cs.exception.handler");
	}


	/**
	 */
	public static class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {
		@Context
		private ResourceContext resourceContext;
		@Override
		public ValidationConfig getContext(final Class<?> type) {
			return new ValidationConfig().constraintValidatorFactory(resourceContext.getResource(InjectingConstraintValidatorFactory.class));
		}
	}
}
