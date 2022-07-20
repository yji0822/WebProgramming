package com.lec.ch02.ex3_student;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StudentInfo {
	
	private Student student; // 의존 - 외부에서 주입해서 사용할 것
	
	public void getInfo() {
		if(student != null) {
			System.out.println("이름 : " + student.getName());
			System.out.println("나이 : " + student.getAge());
			System.out.println("학년 : " + student.getGradeNum());
			System.out.println("반 : " + student.getClassNum());
			System.out.println("==============================");
		} else {
			// 주입 받은 것이 없다면 뿌리지 못한다는 에러메세지
			System.out.println("의존하는 Student형 객체가 없습니다.");
		}
	}
}
