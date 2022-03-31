package com.lec.ex05_test;

public class TestMain {

	public static void main(String[] args) {
		
		TestChildClass obj = new TestChildClass(); // 가지고 있는 객체 모두 사용 가능
		obj.m1();
		obj.m2();
		obj.m3();
		obj.m11();
		System.out.println(I11.i11); //클래스명.static변수
		System.out.println(I3.i3);
		System.out.println(I1.i1); // 상속받아서 모두 사용 가

	}

}
