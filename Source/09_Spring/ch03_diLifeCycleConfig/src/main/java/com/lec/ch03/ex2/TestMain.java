package com.lec.ch03.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		// IOC컨테이너(spring컨테이너) 생성 - 환경설정
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.load("classpath:META-INF/ex2/applicationCTX.xml"); // 빈 생성 전..파싱하는 작업
		ctx.refresh(); // 빈 생성 - person이랑 otherperson 생성 
		// 함수 두개 실행 setEnviroment afterPropertiesSet()
		System.out.println("-----------------------------------");
		
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
		OtherPerson otherPerson = (OtherPerson)ctx.getBean("otherPerson");
		System.out.println(otherPerson);
		
		System.out.println("-----------------------------------");
		ctx.close(); // 빈 객체 닫아주기 전에 destroy() 실행
		System.out.println("빈소멸");
		
		// 어노테이션 파싱하는 context 체크 해주어야 한다.
	
	}

}
