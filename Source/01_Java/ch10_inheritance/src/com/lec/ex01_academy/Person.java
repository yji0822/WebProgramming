package com.lec.ex01_academy;

public class Person {

	// 데이터
	private String no;
	private String id;
	private String name;

	// 생성자
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	// 메소드
	public void print() {
		System.out.print("(번호) " + no + "\t(ID) " + id + "\t (이름) " + name);
	}

	// getter&setter
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

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
