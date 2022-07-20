package com.lec.ch02.ex5_exam;

public interface Exam {
	
	public String getName(); // Exam에는 getName()이 없어서 만들어주어야 한다.
	
	/* 내가 객체를 만들어서 사용하기 위함 */
	public int total(); // 시험점수 합계 return
	public double avg(); // 시험점수 평균 return
	
}
