package com.lec.ex07_friend;
// this. : "내 객체의" a b...
// this() : 현 클래스의 생성자 함수
public class Friend {
	// 데이터-생성자-메소드-setter&getter
	private String name;
//	private int tel; // 01099999999 - 0이 사라진다
	private String tel; // 010-9999-9999 Friend f = new Friend("홍길동", "010-9999-9999");
	
	// 생성자
	public Friend() {
		System.out.println("매개변수 없는 생성자 함수");
	}
	public Friend(String name) {
		this();
		this.name = name;
		System.out.println("매개변수 하나짜리 생성자 함수");
	}
	public Friend(String name, String tel) {
		this(name); // Friend(name) 호출 - 이미 name 생성자에서 호출을 했기 때문에 이렇게 작성해준다!
		this.tel = tel;
		System.out.println("매개변수 두개짜리 생성자 함수");
	}
	// this(); - 지금 내 클래스의 생성자 호출
	
	
	// 메소드
	public String infoString() {
		return "[이름] " + name + ", [전화] " + tel ;
	}
	
	

}
