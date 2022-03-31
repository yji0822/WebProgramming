package com.lec.method;
// Arithmetic.sum/evenOdd (static) vs abs(일반)
public class Ex03 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10); // 합
		System.out.println("1~10까지의 합은 " + tot);
		System.out.println(Arithmetic.evenOdd(10)); // 합의 홀짝 판별
		
		// == Scanner sc = new Scanner();
		Arithmetic ar = new Arithmetic(); 
		// 새로운 메모리에 새로운 타입을 할당해서 메모리 위로 올린 후, 기능을 사용할 수 있게 하도록
		System.out.println(ar.abs(-8)); // static 아닌 일반 메소드라 오류 발생
		
	}

}
