package com.lec.ex;
// 빈 태그 사용하려면.. : (필수요소) 매개 변수 없는 생성자, setter, getter
public class Person {

	private String name; // '홍길동"
	private int age;
	private char gender; // 'f'
	private String address;
	
	// 필수요소 : 매개변수 없는 생성자
	public Person() {}

	public Person(String name, int age, char gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	// 필수요소 getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	} 
	
	
	
}
