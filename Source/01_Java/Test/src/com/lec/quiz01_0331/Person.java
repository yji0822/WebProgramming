package com.lec.quiz01_0331;

public class Person {
	private String name; // �̸�
	private String phone; // ��ȭ��ȣ
	
	// ������
	public Person() {} // ����Ʈ ������
	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	// �޼ҵ�
	@Override
	public String toString() {
		return "�̸� " + name + ", ��ȭ��ȣ " + phone;
	}
	
	// getter&setter
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
		
	
}
