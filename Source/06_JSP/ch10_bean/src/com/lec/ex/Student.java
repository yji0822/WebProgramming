package com.lec.ex;

public class Student {
	
	private String studentNum;
	private String name;
	private int    grade;
	private char   className;
	private int    score;
	
	// 디폴트 생성자와 매개변수 있는 생성자는 현재 데이터 베이스와 연결되는 것이 아니기 때문에 안적어 주어도 된다.
	
	//setters & getters
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
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
	public char getClassName() {
		return className;
	}
	public void setClassName(char className) {
		this.className = className;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}