package com.lec.ex10_customer;

public class Person {
	
	private String name;
	private String tel; // Person p = new Person("홍", "010-9999-9999")
	
	// 생성자 		
	// default 생성자 없이 매개변수 있는 생성자로만!
	public Person(String name, String tel) {
//		super(); - Object()의 생성자
		this.name = name;
		this.tel = tel;
	}
	
	// 메소드
	public String infoString() { // sysout(p.infoString())
		return "[이름] " + name + " [전화] " + tel; 
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
