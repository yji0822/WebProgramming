package com.lec.quiz02_0331;

public class Person {
	
	private String id; // ���̵�
	private String name; // �̸�
	
	// ������
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// �޼ҵ�
	@Override
	public String toString() {
		return "(ID) " + id + " (�̸�) " + name;
	}
	
	// getter&setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
