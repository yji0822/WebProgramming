package com.lec.ch02.ex5_exam;

import lombok.AllArgsConstructor;

@AllArgsConstructor // 매개변수 있는 생성자 함수 출력
public class ExamConsoleImpl2 implements ExamConsole {

	private Exam exam;
	
	public void print() {
			
			System.out.println("========================");
			System.out.println("이름 : " + exam.getName());
			System.out.println("========================");
			System.out.println("총점 : " + exam.total());
			System.out.printf("평균 :%5.1f", exam.avg());
			System.out.println("\n========================");
	}

}
