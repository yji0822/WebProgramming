package com.lec.ex10_customer;

public class Person {
	
	private String name;
	private String tel; // Person p = new Person("ȫ", "010-9999-9999")
	
	// ������ 		
	// default ������ ���� �Ű����� �ִ� �����ڷθ�!
	public Person(String name, String tel) {
//		super(); - Object()�� ������
		this.name = name;
		this.tel = tel;
	}
	
	// �޼ҵ�
	public String infoString() { // sysout(p.infoString())
		return "[�̸�] " + name + " [��ȭ] " + tel; 
	}
	
	
	// getter&setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	

}
