package com.douzone.container.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.container.user.User;

import config.user.AppConfig01;

public class JavaConfig {
	public static void main(String[] args) {
		testJavaConfig01();
		testJavaConfig02();
	}
	
	//Java Config
	//직접 자바설정 클래스를 전달
	//설정 클래스에 @Configuration 필요 x
	public static void testJavaConfig01() {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig01.class);
		
		User user = appContext.getBean(User.class);
		System.out.println(user);
		
		((ConfigurableApplicationContext)appContext).close();
	}
	
	//Java Config02
	//직접 자바설정 클래스가 있는 베이스 패키지를 전달
	//설정 클래스에 @Configuration 필요 O
	public static void testJavaConfig02() {
		ApplicationContext appContext = new AnnotationConfigApplicationContext("config.user");
		
		User user = appContext.getBean(User.class);
		System.out.println(user);
		
		((ConfigurableApplicationContext)appContext).close();
	}
}
