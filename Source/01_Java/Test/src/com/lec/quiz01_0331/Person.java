package com.lec.quiz01_0331;

public class Person {
	private String name; // 이름
	private String phone; // 전화번호
	
	// 생성자
	public Person() {} // 디폴트 생성자
	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	// 메소드
	@Override
	public String toString() {
		return "이름 " + name + ", 전화번호 " + phone;
	}
	
	// getter&setter
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
		
	
}
