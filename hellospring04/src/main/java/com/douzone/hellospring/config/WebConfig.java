package com.douzone.hellospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
// web 설정임을 알려줘야 함. ViewResolver, HandlerMapping? 이런게 생성됨.
@ComponentScan({"com.douzone.hellospring.controller"})
// @Component를 스캔하기 위함..?
public class WebConfig {
	
//  xml bean에 설정되어 있는 것을 설정 해준것. (자바에 명시적으로)
	@Bean
	public ViewResolver vr() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		
		return resolver;
	}
}
