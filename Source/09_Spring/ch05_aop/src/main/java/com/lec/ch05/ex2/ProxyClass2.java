package com.lec.ch05.ex2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ProxyClass2 {
	// 공통기능 로직이 담겨있는 ProxyClass
	
	/* 방법1
	@Pointcut("within(com.lec.ch05.ex2.*)")
	private void aroundM() {}
	@Around("aroundM()") */
	
	// aroundAdvice (제일 어렵... 이거만 이해하면 뒤에는 문제 없다)
	/* 핵심기능 전후로 공통기능 수행 */
	// 핵심기능이 리턴타입이 있을 수도 있으므로 object 타입으로 받는다
	// 이것의 핵심은 aroundAdvice 수행하고 핵심기능(join poin) 수행했다가 다시 이쪽(aroundAdvice)으로 와서 수행을 한다.
	
	/* 방법2 - 세개의 줄을 한줄로 압축해서 표현하는 방법 
	 * : within을 @Around 안에 넣어줘도 된다. */
	@Around("within(com.lec.ch05.ex2.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		String signatureName = joinPoint.getSignature().toString(); // 핵심기능 메소드명 가져오는 로직
		System.out.println(signatureName + "가 시작되었습니다.");
		// 몇초가 걸리는지 모르므로 currentTimeMills() 
		long startTime = System.currentTimeMillis(); // 시작시점
		try {
			// joinPoint가 핵심기능 / 핵심기능에서 에러가 날 수도 있으므로 예외처리
			Object obj = joinPoint.proceed(); // ★☆ 핵심기능 실행 ★☆
			return obj;
		} finally {
			// catch절 삭제 - 또다른 예외가 발생할 수 있으므로...
			long endTime = System.currentTimeMillis(); // 핵심기능 수행 후 끝나는 시점
			System.out.println(signatureName + "가 수행되는 경과 시간 : " + (endTime-startTime));
		}
	
	}
	
	
	// before Advice
	@Before("execution(* com.lec.ch05.ex2.Student2.*())")
	public void beforeAdvice() {
		System.out.println("핵 심 기 능 수행하기 전에 알아서 beforeAdvice(공통기능) 수행");
	}
	
	// after Advice
	@After("bean(stud*)")
	public void afterAdvice() {
		System.out.println("핵 심 기 능 수행하고 난 뒤 알아서 afterAdvice(공통기능) 수행");
	}
	
	// after-return Advice
	@AfterReturning("within(com.lec.ch05.ex2.Worker2)")
	public void afterReturningAdvice() {
		System.out.println("정상적으로(예외가 발생되지 않고) 핵심기능이 수행된 후 이 공통기능(afterReturnAdvice()) 수행");
	}
	
	// after-throwing Advice
	@AfterThrowing("execution(void com.lec.ch05.ex2.Worker2.get*())")
	public void afterThrowingAdvice() {
		System.out.println("예외가 발생된 핵심기능이 수행된 후 이 afterThrowingAdvice()로직 수행");
	}
}
