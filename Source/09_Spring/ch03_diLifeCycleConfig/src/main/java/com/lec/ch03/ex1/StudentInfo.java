package com.lec.ch03.ex1;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class StudentInfo {
	
	@Autowired // setter를 이용하지 않아도 알아서 의존하는 클래스의 객체를 불러오는 방식
	private Student student;
	
	/* 과거에 사용하던 방식 - setter를 이용해서 불러오는 방식
	@Autowired
	public void setStudent(Student student) {
		this.student = student;
	} */
}
