package com.aop.prac.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SysoutAspect {

	/*
	 * GetMapping 어노테이션이 들어간 모든 메서드에 적용
	 */
	
	/**
     *   PointCut : Aspect를 적용할 위치를 지정
     *   따라서 아래와 같이 @GetMapping을 포인트컷으로 지정했으니, GetMapping 어노테이션이 들어간 메서드에 AOP를 적용하겠다!!
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping(){ }
	
    /*
     * Around : 메서드 실행 전과 후에 동작
     */
	@Around("GetMapping()")
	public Object Around(ProceedingJoinPoint joinPoint) throws Throwable{
		// 메서드 실행 전 출력
		System.out.println("=======Start=======");
		try {
			Object result = joinPoint.proceed();
			// 메서드 실행 후 출력
			System.out.println("=======END=======");
			
			// 비즈니스 메서드의 리턴값을 받는 것!
			System.out.println("메서드 리턴 값: "+result);
			return result;
		} catch(Exception e) {
			System.out.println("======EXCEPTION======");
			System.out.println(e.toString());
			
			return null;
		}
	}
}
