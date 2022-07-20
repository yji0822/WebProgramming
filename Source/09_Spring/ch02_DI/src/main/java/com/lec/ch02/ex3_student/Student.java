package com.lec.ch02.ex3_student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 매개변수 있는 생성자 함수만 존재
public class Student {
	
	private String name;
	private int age;
	private String gradeNum;
	private String classNum;
	
}
