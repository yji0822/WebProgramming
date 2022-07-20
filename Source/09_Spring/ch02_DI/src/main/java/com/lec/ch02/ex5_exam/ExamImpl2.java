package com.lec.ch02.ex5_exam;

import lombok.Data;

@Data //getName 대신
public class ExamImpl2 implements Exam {
	// 이름, 국어, 영어 수학, 컴퓨터의 이름과 총점, 평균을 출력
	// 수정 후 과목이 축소
	// 이름, 국어, 영어, 수학을 이용해서 이름과 총점, 평균을 출력
	
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	public int total() {
		return kor+eng+mat;
	}
	
	public double avg() {
		return total() / 3.0; // 평균이기 때문에 
	}

	
}
