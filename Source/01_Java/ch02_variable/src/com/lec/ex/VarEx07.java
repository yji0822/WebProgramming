package com.lec.ex;

public class VarEx07 {

	public static void main(String[] args) {
		int i1 = 10; // 4byte
		long l1 = 2200000000L; // int 형으로 인식할 수 없어서 뒤에 L을 붙여준다. 8byte
		
		// 작은 byte값을 큰 byte공간으로
		double d1 = 10; // 8byte = 4byte - 가능 / 묵시적인 형변환
		System.out.println("d1 = " + d1); // 10.0 출력 - double형으로 형변환
		
		double d2 = 10.19;
		// 큰 byte를 작은 byte로 넣고 싶을때  꾸겨 넣던 자르고 넣던...
		// 명시적인 형변환 (데이터 손실이 발생할 수도 있음)
//		int i2 = d2; // 에러발생
		int i2 = (int)d2;
		System.out.println("i2 = " + i2);

	}

}
