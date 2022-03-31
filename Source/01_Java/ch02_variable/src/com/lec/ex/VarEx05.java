package com.lec.ex;

public class VarEx05 {

	public static void main(String[] args) {
		boolean b = true; // ture or false 만 가능
		char c = 'c';
		// 실수형은 사용할때 주의!! - float형 보단 double형을 많이 쓰자
		float f1;
		f1 = 10.1f; 
		// 실수형은 기본이 double형
		// 큰값인 double을 float에 넣으려고 하면 에러 발생
		// float 숫자 선언 시, F or f를 써주어야 함.
		System.out.println("f1=" + f1);
		f1 = 10.0000017f;
		double d = 10.0000017;
		System.out.println("f1 = " + f1); // f1 = 10.00002 로 반올림 출력
		System.out.println("d = " + d); // d = 10.0000017 로 정상출력
		// double만 쓴다고 생각하면 됨, float는 위험함. 숫자변형이 되기 때문
		
		f1 = 10.1f;
		d = 10.1;
		if (f1==d)
		{
			System.out.println("두 변수는 같다");
		}
		else {
			System.out.println("두 변수는 다르다");
		}
		// '두 변수는 다르다' 라고 출력이 된다. float와 double 같다고 취급하지 않음!
		
	}

}
