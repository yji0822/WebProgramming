package com.lec.ex01_parentchild;

public class ParentClass {
	
	String pStr = "부모클래스";
	
	// 생성자
	public ParentClass() {
		System.out.println("부모클래스 객체 부분 생성");
	}
	public void getPapaName() {
		System.out.println("아빠 이름 : 홍길동");
	}
	public void getMamiName() {
		System.out.println("엄마 이름 : 이길순");
	}
	

}

// 기본적으로 부모 클래스도 Object 클래스를 상속받아서 사용하는 것이다.