package com.freetimeapps.fantabetty.module;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class FantabettyServletModule extends ServletModule {

	@Override
	protected void configureServlets() {

		ResourceConfig rc = new PackagesResourceConfig(
				"com.freetimeapps.fantabetty.server");
		for (Class<?> resource : rc.getClasses()) {
			bind(resource);
		}

	   bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);
		
		final Map<String, String> params = new HashMap<String, String>();
		params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
		serve("/rest/*").with(GuiceContainer.class, params);

		filter("/*").through(ObjectifyFilter.class);
	}
}