package com.lec.ch05.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain2 {

	public static void main(String[] args) {
		
//		String location="classpath:META-INF/applicationCTX1.xml"; // 위빙이 되어있는 상태
		String location="classpath:META-INF/applicationCTX2.xml"; // annotation 이용
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		// 함수호출
		Student2 student = ctx.getBean("student2", Student2.class);
		Worker2 worker = ctx.getBean("worker2", Worker2.class);
		
		// 핵심기능 불러오기
		student.getStudentInfo();
		System.out.println("-------- 구분선 --------");
		worker.getWorkerInfo();
	}

}
