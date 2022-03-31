package com.lec.ex1_student1;

public class Student1 {
	
	private String name; // 이름
	private int    kor; // 국어점수
	private int    eng; // 영어점수
	private int    math; // 수학점수
	private int    tot; // 합계점수
	private double avg; // 평균점수
	
	// 생성자
	public Student1() {}
	public Student1(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		tot = kor+eng+math;
		avg = tot / 3.0;
	}
	
	// disp
	public void Disp() {
		System.out.println("\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t"
				+ tot + "\t" + avg);
		}
	
	// getter
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
	
	
	
	
	

	
}
