package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		S s = new S();
//		A s1 = new S(); - 거꾸로는 불가!
//		A a = new A();
		// A형이 S형이 될 수 있음
		S a = new A(); // 반드시 형식을 이렇게 작성해주어야 한다.
		// S와 A의 형식 일치
		S b = new B(); // 변수가 S 타입이고 B형 객체이다.
		S c = new C();
		S[] arr = {s, a, b, c}; // 타입을 일치 시킨 후, 배열로 정리 - 패턴을 만들기 위한 작업
		for(S obj:arr) { // S type의 arr, obj
			System.out.println(obj.s); // S클래스의 int s
		}
		
	}

}
