package com.lec.ex8_student;

public class Student {
	
	private static int count = 0;
	private int studentNo;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	// ������
	public Student() {
		
	} // ����Ʈ ������
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		tot = kor+eng+math;
		avg = tot/3.0;
		studentNo = ++count;
	}
	
	// disp
	public void disp() {
		System.out.printf(" %d \t %s \t %d \t %d \t %d \t %d \t %.1f \n"
						, studentNo, name, kor, eng, math, tot, avg);
	}
		
	// getter & setter
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
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}	
	
	
}
