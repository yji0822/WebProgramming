package com.lec.quiz01_academy;

public class Student extends Person {
	
	private static int num = 0;
	private String ban;
	
	// ������
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		++num;
		setNo("st10" + num);
	}
	
	// �޼ҵ�
	@Override
	public void print() {
		super.print();
		System.out.println("\t(��) " + ban);
	}

	// getter&setter
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	
	
	
	

	

}
