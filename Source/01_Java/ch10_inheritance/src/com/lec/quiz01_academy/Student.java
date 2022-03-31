package com.lec.quiz01_academy;

public class Student extends Person {
	
	private static int num = 0;
	private String ban;
	
	// 생성자
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		++num;
		setNo("st10" + num);
	}
	
	// 메소드
	@Override
	public void print() {
		super.print();
		System.out.println("\t(반) " + ban);
	}

	// getter&setter
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	
	
	
	

	

}
