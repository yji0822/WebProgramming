package com.lec.ex09_super;
// super();
// Person p = new Person("ȫ�浿", "����");
// �Ű����� 2�� �ִ� �����ڷ� ȣ���� �� �ֵ���
public class Person {

	private String name;
	private String character;
	
	// ������
	public Person() {
		System.out.println("�Ű�����=�Ķ����=���ڰ� ���� Person ������");
	}
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("�Ű����� 2��¥�� Person ������");
	}
	
	// �޼ҵ�
	public void intro() {
		System.out.println(name + "��(��) " + character );
	}
	
	// getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	
	
}
