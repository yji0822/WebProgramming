package com.lec.ex6_wrapper;

public class Ex03_method {

	public static void main(String[] args) {
		
		// 엄청 많이 쓰임!! ****
		System.out.println("(1) String을 Integer로 바꾸는 함수: Integer.parseInt(문자열)");
		int i = Integer.parseInt("10");
		System.out.println(i);
		
		// 간혹가다 쓰임
		System.out.println("(2) Integer를 String으로 바꾸는 함수: String.valueOf(숫자)");
		String monthStr = "" + 12; // String형으로 변환 "12"
		monthStr = String.valueOf(12);
		System.out.println(monthStr);
		
	}

}
