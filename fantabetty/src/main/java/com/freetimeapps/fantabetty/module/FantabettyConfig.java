package com.freetimeapps.fantabetty.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class FantabettyConfig extends
		GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new FantabettyModule(),
				new FantabettyServletModule());
	}
}