package com.lec.ex01;
// CONSTANT_NUM, CONSTANT_STRING, method1(�߻�), method2(�߻�)
public class InterfaceClass implements InterfaceEx1, InterfaceEx2 {
	
	// Ŭ������ ������ �߻�޼ҵ� �޾ƿ��� ctrl+1
	@Override
	public void method1() {
		System.out.println("���� ������ implements�� Ŭ�������� �մϴ�. method1");
		
	}
	@Override
	public String method2() {
		System.out.println("���� ������ implements�� Ŭ�������� �մϴ�. method2");
		return null;
	}
	// ��ü�� ��ǰȭ - �� or ��
	
}
