package com.lec.ex;
// 다른 패키지의 함수를 불러와서 쓰고 싶을 때! - import의 유무
// Arithmetic();
import com.lec.method.Arithmetic;

public class Ex04 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);	
		System.out.println(tot);
		Arithmetic ar = new Arithmetic();
		// 클래스 새로운 타입을 만드는 것 / ar = 객체, 객체변수, 인스턴스 (클래스를 메모리에 올려놨다)
		System.out.println("-8800의 절대값은 " + ar.abs(-8800));
	}

}
