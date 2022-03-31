package com.lec.ex1_student;

public class Student1 {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	// 생성자
	public Student1() {}
	public Student1(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		tot = kor+eng+math;
		avg = tot/3.0;
	}
	
	// getter&setter - getter만 필요하다.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
	// disp
	public void Disp() {
		System.out.println("\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t"
				+ tot + "\t" + avg);
	}	
	
	
}
