package com.lec.ch02.ex1_cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyCalTestMain {

	public static void main(String[] args) {
		
		// 파싱 먼저 해주기
		// applicationCTX1 에서 만든것을 파싱을 먼저 해준다.
		String resourceLocation = "classpath:applicationCTX1.xml"; 
		AbstractApplicationContext ctx 
			= new GenericXmlApplicationContext(resourceLocation);
		
		MyCalculator myCalculator = ctx.getBean("myCal", MyCalculator.class); // 주입 받아서 사용하는 친구
		
		// myCalculator도 Calculator를 의존받아서 사용하고 있다.
		// num1에는 50, num2에는 10이 들어가있다.
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		
		ctx.close();
		
	} // main
}
