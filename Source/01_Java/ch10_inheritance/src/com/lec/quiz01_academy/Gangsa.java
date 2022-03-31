package com.lec.quiz01_academy;

public class Gangsa extends Person {

	private static int num = 0;
	private String subject;
	
	// ������
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		++num;
		setNo("lec" + num);
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("\t(����) " + subject);
	}

}
