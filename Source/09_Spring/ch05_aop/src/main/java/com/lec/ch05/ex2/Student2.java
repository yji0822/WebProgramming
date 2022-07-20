package com.lec.ch05.ex2;

import lombok.Data;

@Data
public class Student2 {
	
	private String name;
	private int    age;
	private String gradeNum;
	private int    classNum;
	
	public void getStudentInfo() {
		// 메인함수에 대놓고 호출될 친구 - 핵심기능 (타겟메소드 = 비즈니스로직)
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("학년 : " + gradeNum);
		System.out.println("반 : " + classNum);
	}
	
}
