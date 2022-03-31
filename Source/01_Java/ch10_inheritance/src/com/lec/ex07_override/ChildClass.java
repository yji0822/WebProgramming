package com.lec.ex07_override;

public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("매개변수 없는 ChildClass 생성자");
	}
	public ChildClass(int i) {
		System.out.println("매개변수 있는 ChildClass 생성자");
	}
	
	// 메소드
	public void method3() {
		System.out.println("ChildClass의 method3() 함수");
	}
	
	// 오버라이드 - 함수의 재정의
	@Override
	public void method1() {
		System.out.println("ChildClass의 method1()함수");
	}
	// 접근제한자의 범위만 바꿀 수도 있다. private > public 이런 식으로
	
	@Override
	public boolean equals(Object obj) {
		return true; // 무조건 true를 출력하는 것으로 변경한 오버라이드 메소드
	}
	
}
