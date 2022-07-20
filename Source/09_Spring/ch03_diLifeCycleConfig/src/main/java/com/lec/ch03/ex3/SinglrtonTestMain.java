package com.lec.ch03.ex3;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.ex1.Family;

public class SinglrtonTestMain {

	public static void main(String[] args) {
		//ch01의 Family.class 참고
		
		String location = "classpath:META-INF/ex3/applicationCTX.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		// 싱글톤 family - family1과 family2는 같은 Family이다.
		Family family1 = ctx.getBean("family", Family.class); 
		Family family2 = ctx.getBean("family", Family.class); 
		
		family1.setPapaName("박아빠");
		family1.setMamiName("최엄마");
		
		System.out.println("family1 : " +family1);
		System.out.println("family2 : " +family2);
		
		System.out.println("-------------------------------");
		// scope=prototype으로 만들어준 familyPrototype 빈은 각기 다른 Family로 인식된다.
		Family family3 = ctx.getBean("familyPrototype", Family.class);
		Family family4 = ctx.getBean("familyPrototype", Family.class);
		
		family3.setPapaName("윤아빠");
		family3.setMamiName("서엄마");
		
		System.out.println("family3 : " +family3);
		System.out.println("family4 : " +family4);
		
		ctx.close(); // 닫아주기

	}

}
