package com.lec.ex3_math;

public class Ex01_Math {

	public static void main(String[] args) {
		
		int a=2, b=10;
		
		System.out.println("2의 10 제곱은? " + (int)Math.pow(a, b)); // a의 b제곱, double타입 - java.lang 포함이라 따로 import해주지 않으셔도 된다.
		System.out.println("-9.9의 절대값은? " + Math.abs(-9-9)); // 절대값
		System.out.println("2의 제곱근은? " + Math.sqrt(a)); // 제곱근
		System.out.println("a와 b 중 최소값은? " + Math.min(a, b)); // 최소값
		System.out.println("a와 b 중 최대값은? " + Math.max(a, b)); // 최대값
		
		// 함수만 존재하는 것이 아닌 변수도 존재하는 Math 클래스! (static final 변수)
		System.out.println("PI값은? " + Math.PI);
		

	}

}
