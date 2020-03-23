package com.douzone.container.test;

import javax.security.auth.login.AppConfigurationEntry;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.Friend;
import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfig {
	public static void main(String[] args) {
		//xml Auto Configuration(Annotation Scanning)
		//		testBeanFactory01();
		
		//xml bean Configuration(explicity Configuration)
		//		testBeanFactory02();
		
		//xml Auto Configuration(Annotation Scanning)
		//		testApplicationContext01();
		
		//xml bean Configuration(explicity Configuration)
		testApplicationContext02();
	}
	
	public static void testBeanFactory01() {
		
		//xml Auto Configuration(Annotation Scanning)
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext01.xml")); //연습용
		//bean 생성
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		//Bean의 id가 자동으로 설정됨.
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
	
	public static void testBeanFactory02() {
		
		//xml bean Configuration(explicity Configuration)
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext02.xml")); //연습용
		//bean 생성
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		//Bean 설정에서는 id가 자동으로 설정 안됨.
		//명시적으로 설정해야함.
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
	
	public static void testApplicationContext01() {
		
		//xml Auto Configuration(Annotation Scanning)
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/user/applicationContext01.xml");
		
		//bean 생성
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());
		
		//Bean 설정에서는 id가 자동으로 설정 안됨.
		//명시적으로 설정해야함.
		user1 = (User1)ac.getBean("user1");
		System.out.println(user1.getName());
	}
	
	public static void testApplicationContext02() {
		
		//xml bean Configuration(Explicity Configuration)
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/user/applicationContext02.xml");
		
		// id로 빈 가져오기
		User user = (User)ac.getBean("user");
		System.out.println(user);
		
		// name으로 빈 가져오기
		user = (User)ac.getBean("usr");
		System.out.println(user);
		
	// --- type으로 가져오기
		//같은 type의 객체가 2개 이상 있는 경우 type으로만 가져오면 에러. 그래서 type + id 또는 type + name으로 가져와야함.
		user = ac.getBean("user2",User.class);
		System.out.println(user);
		
		//2개 파라미터 생성자로 생성된 빈 가져오기
		user = ac.getBean("user3",User.class);
		System.out.println(user);
		
		//2개 파라미터 생성자로 생성된 빈 가져오기 - 순서의 차이
		user = ac.getBean("user4",User.class);
		System.out.println(user);
		
		//setter를 사용한 빈 가져오기.
		user = ac.getBean("user5",User.class);
		System.out.println(user);
		
		user = ac.getBean("user6",User.class);
		System.out.println(user);
		
		user = ac.getBean("user7",User.class);
		System.out.println(user);
//		Friend f = ac.getBean(Friend.class);
//		System.out.println(f);
		
		//자원정리
		((ConfigurableApplicationContext)ac).close();
	}
}
