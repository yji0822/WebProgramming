package com.lec.ex05_abc;

public class TestMain {

	public static void main(String[] args) {
		
		S s = new S();
//		A s1 = new S(); - 거꾸로는 불가
		S a = new A(); // S타입 변수 B형 객체
		S b = new B();
		S c = new C();
		
		S[] arr = {a, b, c}; // 앞에서 일치시킨 타입을 배열로 정리
		
		for(S obj : arr) {
			System.out.println(obj.s);
		}
		

	}

}
