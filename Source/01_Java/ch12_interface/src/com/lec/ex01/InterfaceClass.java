package com.lec.ex01;
// CONSTANT_NUM, CONSTANT_STRING, method1(추상), method2(추상)
public class InterfaceClass implements InterfaceEx1, InterfaceEx2 {
	
	// 클래스명 누르고 추상메소드 받아오기 ctrl+1
	@Override
	public void method1() {
		System.out.println("실제 구현은 implements한 클래스에서 합니다. method1");
		
	}
	@Override
	public String method2() {
		System.out.println("실제 구현은 implements한 클래스에서 합니다. method2");
		return null;
	}
	// 객체의 부품화 - 금 or 월
	
}
