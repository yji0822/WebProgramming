package com.lec.ex06_override;

public class ParentClass {

	// 생성자 overloading = 함수 중복 정의 (매개변수의 수나 타입을 달리하는 것)
	public ParentClass() {
		System.out.println("매개변수 없는 ParentClass 생성자");
	}
	public ParentClass(int i) {
		System.out.println("매개변수 있는 ParentClass 생성자");
	}
	
	// method
	public void method1() {
		System.out.println("ParentClass의 method1() 함수");
	}
	public void method2() {
		System.out.println("ParentClass의 method2() 함수");
	}
	
	// 데이터가 없으므로 getter&setter 불가
	
}
