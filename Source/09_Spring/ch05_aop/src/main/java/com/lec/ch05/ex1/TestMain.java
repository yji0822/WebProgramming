package com.lec.ch05.ex1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		String location="classpath:META-INF/applicationCTX1.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		// 함수호출
		Student student = ctx.getBean("student", Student.class);
		Worker worker = ctx.getBean("worker", Worker.class);
		
		// 핵심기능 불러오기
		student.getStudentInfo();
		System.out.println("-------- 구분선 --------");
		worker.getWorkerInfo();
	}

}
