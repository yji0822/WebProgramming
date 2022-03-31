package com.lec.ex2;
// method1(추상메소드), method2(일반메소드) 모두 상속
public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("ChildClass의 method1 - 추상 메소드라서 오버라이드 함");
	}
	
	// 필요에 따라 오버라이드 할 수 있는 일반 메소드 method2()
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2 - 일반 메소드지만 그냥 오버라이드 함");
	}
	
}
