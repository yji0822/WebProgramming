package com.lec.quiz02_0331;

public class Gangsa extends Person {

	private String subject; // ����
	
	// ������
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}
	
	// �޼ҵ�
	@Override
	public String toString() {
		return super.toString() + " (����) " + subject;
	}
	
	// getter & setter
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
