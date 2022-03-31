package com.lec.ex01_academy;

public class Gangsa extends Person {

	private static int num = 0;
	private String subject;
	
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		++num;
		setNo("lec" + num);
	}
	
	// method
	@Override
	public void print() {
		super.print();
		System.out.println("\t(°ú¸ñ) " + subject);
	}
	
	// getter & setter
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

}
