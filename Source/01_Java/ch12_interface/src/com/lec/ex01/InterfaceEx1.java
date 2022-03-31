package com.lec.ex01;
// 상수(final변수), 추상메소드만 존재할 수 있다.
public interface InterfaceEx1 {

	public static final int CONSTANT_NUM = 10;
	// public int CONSTANT_NUM = 10; 가능
	public /*abstract*/ void method1(); // 생략가능 대부분 생략 가능
	
}
