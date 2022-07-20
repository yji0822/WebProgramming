package com.lec.ch02.ex3_student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentTestMain {

	public static void main(String[] args) {
		
		String configLocation = "classpath:applicationCTX3.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation); // 파싱
		
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class); // 컴포넌트 가져오기
		studentInfo.getInfo(); // studentInfo 안에 student가 있고 student1에 정보가 들어가있다.
		Student student1 = ctx.getBean("student1", Student.class); // 컴포넌트 가져오기
		
		// 100퍼센트 일치하는지 확인해보는 작업
		if(student1.equals(studentInfo.getStudent())) {
			System.out.println("student1과 studentInfo.getStudent()는 같다.");
		}
		
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2);
		studentInfo.getInfo();
		ctx.close();
		
	} // main

}
