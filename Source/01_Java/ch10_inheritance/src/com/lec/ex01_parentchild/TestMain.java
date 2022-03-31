package com.lec.ex01_parentchild;

public class TestMain {

	public static void main(String[] args) {
		
		ChildClass child = new ChildClass();
		// 1. 부모클래스에 먼저 가서 관련 객체를 만든 다음, 2. 자식클래스의 메모리를 생성한다.
		child.getMamiName();
		child.getPapaName();
		System.out.println(child.pStr); // 부모클래스의 변수도 호출 가능
		System.out.println(child.cStr); // 자식클래스의 변수 호출 당연히 가능
		
	}

}
