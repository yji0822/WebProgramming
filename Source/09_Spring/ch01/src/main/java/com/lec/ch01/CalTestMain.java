package com.lec.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalTestMain {

	public static void main(String[] args) {
		
		// main 함수 만들어서 테스트 하는 공간
		// CalTestMain이랑 Calculation은 의존관계 - dependency injection
		
		/* 방법1
		Calculation cal = new Calculation();
		cal.setNum1(50);
		cal.setNum2(10);*/
		
		// 방법2 
		AbstractApplicationContext ctx 
				= new GenericXmlApplicationContext("classpath:applicationCTX.xml"); // 추상클래스 생성
		// 이미 이름을 만들어 놨음
		Calculation cal = ctx.getBean("calculation", Calculation.class);
				
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		System.out.println(cal); // toString으로 결과 출력
		ctx.close(); // 사용하지 않는다면 닫아준다.

	}

}
