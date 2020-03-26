package com.douzone.hellospring.initiallizer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.douzone.hellospring.config.WebConfig;

public class HellospringWebApplicationInitiallizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
//	Root Application Context 설정.
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	//web Application Context 설정.
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// 서블릿 매핑
		return new String[] {"/"};
	}

}
