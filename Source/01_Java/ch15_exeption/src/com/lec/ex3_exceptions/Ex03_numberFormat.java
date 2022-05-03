package com.lec.ex3_exceptions;

public class Ex03_numberFormat {

	public static void main(String[] args) {
		
//		int i = Integer.parseInt(""); // 빈 스트링은 숫자로 변환 안됨. 예외발생
		int i = Integer.parseInt("100 "); // space가 들어가도 예외발생됨
		System.out.println(i);

	}

}
