package com.lec.ex2;

public class TestMain {

	public static void main(String[] args) {
		
		SuperClass obj = new ChildClass(); // 변수의 타입으로는 만들 수 있음
		obj.method1();
		obj.method2();
		
//		SuperClass s = new SuperClass() {
//			// 추상클래스는 변수는 만들 수 있음
//			public void method1() {
//				System.out.println("main 익명클래스 생성");
//			} // 임의로 불러서 실행시키는 method1
//		}; // SuperClass를 빙자한 익명의 클래스
//		s.method1();
		
		
	}

}
