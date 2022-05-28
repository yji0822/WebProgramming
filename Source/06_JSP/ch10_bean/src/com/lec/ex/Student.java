package com.lec.ex;

public class Student {

	private String sno; // 학번
	private String name; // 이름
	private int grade; // 학년
	private char classs; // 반
	private int score; // 점수
	
	public Student() {}
	public Student(String sno, String name, int grade, char classs, int score) {
		super();
		this.sno = sno;
		this.name = name;
		this.grade = grade;
		this.classs = classs;
		this.score = score;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getClasss() {
		return classs;
	}
	public void setClasss(char classs) {
		this.classs = classs;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

