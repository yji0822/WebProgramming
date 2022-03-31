package com.lec.quiz02_0331;

public class Person {
	
	private String id; // 아이디
	private String name; // 이름
	
	// 생성자
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// 메소드
	@Override
	public String toString() {
		return "(ID) " + id + " (이름) " + name;
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
