package com.lec.quiz02_0331;

public class Student extends Person {
	
	private String ban; // ��
	
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
	}
	
	// method
	@Override
	public String toString() {
		return super.toString() + " (��) " + ban; 
	}

	// getter & setter
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	
		
	
	
}
