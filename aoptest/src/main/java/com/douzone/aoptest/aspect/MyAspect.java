package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))") 
	// "~" 이것이 실행되기 전에 beforeAdvice()를 실행해라
	public void beforeAdvice() {
		System.out.println("------before Advice ------");
	}
	
	@After("execution(* *..*.service.ProductService.*(..))")
	//모든 return 타입 * 모든 패키지 밑의 Service를 불러내겠다
	public void afterAdvice() {
		System.out.println("------after Advice -------");
	}
	
	@AfterReturning("execution(* *..*.service.ProductService.*(..))")
	public void afterReturningAdvice() {
		System.out.println("---afterReturning Advice---");
	}
	
	@AfterThrowing(value = "execution(* *..*.*.*(..))", throwing = "ex")
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("===afterThrowing===="+ ex + "----");
	}
	
	@Around("execution(* *..*.service.ProductService.*(..))")
	public Object arroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		//before advice
		System.out.println("@Around(before) Advice");
		
		//PointCut Method 실행
		//파라미터 가로채기(바꿔버리기)
//		Object[] params = {"camera"};
//		Object result = pjp.proceed(params); // 중간메소드 실행
		
		Object result = pjp.proceed();
		
		//after advice
		System.out.println("@Around(after) Advice");
		
		return result;
	}
}
