package com.lec.ch03.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		String resourcesLocation1 = "classpath:META-INF/ex1/applicationCTX1.xml";
		String resourcesLocation2 = "classpath:META-INF/ex1/applicationCTX2.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourcesLocation1, resourcesLocation2);
		
		// student 빈 불러오기
		Student student = ctx.getBean("student", Student.class);
		System.out.println("student: " + student);
		
		// studentInfo 빈 불러오기
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		System.out.println("studentInfo의 student : " + studentInfo.getStudent());
		
		if(student.equals(studentInfo.getStudent())) {
			System.out.println("student와 studentInfo는 같은 객체");
		}
		
		Family family = ctx.getBean("family" , Family.class);
		System.out.println(family);
		
		ctx.close(); // 컨테이너 소멸: 컨테이너 안의 빈 자동 소멸
	}

}
