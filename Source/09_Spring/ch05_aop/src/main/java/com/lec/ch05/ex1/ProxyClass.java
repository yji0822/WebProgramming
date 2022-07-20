package com.lec.ch05.ex1;

import org.aspectj.lang.ProceedingJoinPoint;

public class ProxyClass {
	// 공통기능 로직이 담겨있는 ProxtClass
	
	// aroundAdvice (제일 어렵... 이거만 이해하면 뒤에는 문제 없다)
	/* 핵심기능 전후로 공통기능 수행 */
	// 핵심기능이 리턴타입이 있을 수도 있으므로 object 타입으로 받는다
	// 이것의 핵심은 aroundAdvice 수행하고 핵심기능(join poin) 수행했다가 다시 이쪽(aroundAdvice)으로 와서 수행을 한다.
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
	public void beforeAdvice() {
		System.out.println("핵 심 기 능 수행하기 전에 알아서 beforeAdvice(공통기능) 수행");
	}
	
	// after Advice
	public void afterAdvice() {
		System.out.println("핵 심 기 능 수행하고 난 뒤 알아서 afterAdvice(공통기능) 수행");
	}
	
	// after-return Advice
	public void afterReturningAdvice() {
		System.out.println("정상적으로(예외가 발생되지 않고) 핵심기능이 수행된 후 이 공통기능(afterReturnAdvice()) 수행");
	}
	
	// after-throwing Advice
	public void afterThrowingAdvice() {
		System.out.println("예외가 발생된 핵심기능이 수행된 후 이 afterThrowingAdvice()로직 수행");
	}
}
