package com.lec.quiz01_academy;

public class Gangsa extends Person {

	private static int num = 0;
	private String subject;
	
	// 持失切
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		++num;
		setNo("lec" + num);
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("\t(引鯉) " + subject);
	}

}
