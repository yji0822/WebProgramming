package com.lec.ex1_student1;

public class Student1 {
	
	private String name; // �̸�
	private int    kor; // ��������
	private int    eng; // ��������
	private int    math; // ��������
	private int    tot; // �հ�����
	private double avg; // �������
	
	// ������
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
