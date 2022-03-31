package com.lec.ex09_super;
// super();
// Person p = new Person("홍길동", "착해");
// 매개변수 2개 있는 생성자로 호출할 수 있도록
public class Person {

	private String name;
	private String character;
	
	// 생성자
	public Person() {
		System.out.println("매개변수=파라미터=인자가 없는 Person 생성자");
	}
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("매개변수 2개짜리 Person 생성자");
	}
	
	// 메소드
	public void intro() {
		System.out.println(name + "은(는) " + character );
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
