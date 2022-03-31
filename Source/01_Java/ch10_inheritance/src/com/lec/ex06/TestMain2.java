package com.lec.ex06;

public class TestMain2 {

	public static void main(String[] args) {
//		Child1 c1 = new Child1(10);
		Super c1 = new Child1(10);
		System.out.println("c1.s = " + c1.s);
//		System.out.println(c1.c1); - 컴파일에러 // c1의 타입이 현재 Super이기 떄문에 Super클래스 안의 메소드만 실행 가능하다
		System.out.println(((Child1)c1).c1); // 해결방안 - c1 객체 변수의 명시적 형변환

	}

}
