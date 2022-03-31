package com.lec.quiz02_0331;

public class Gangsa extends Person {

	private String subject; // 苞格
	
	// 积己磊
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}
	
	// 皋家靛
	@Override
	public String toString() {
		return super.toString() + " (苞格) " + subject;
	}
	
	// getter & setter
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
