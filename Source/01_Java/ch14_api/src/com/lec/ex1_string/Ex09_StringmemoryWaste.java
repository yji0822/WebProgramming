package com.lec.ex1_string;

public class Ex09_StringmemoryWaste {

	public static void main(String[] args) {
		// String 변수의 값을 바꿀 때마다 객체가 새롭게 생성됩니다.
		String str1 = "Hello";
		String str2 = "Hello";
		
		System.out.println(str1==str2 ? "같은 주소" : "다른 주소");
		
		// hashCode() - 주소 비스무리한것을 찍어주는 함수
		System.out.println("str1의 해시코드 : " + str1.hashCode());
		System.out.println("str2의 해시코드 : " + str2.hashCode());
		
		str1 = "Hello~"; // 기존의 객체를 버리고 새로운 객체를 생성하는 String 변수
		System.out.println("str1의 해시코드(변경1) : " + str1.hashCode());
		System.out.println(str1==str2? "같은 주소" : "다른 주소");
		
		str1 = "Hello!!!";
		System.out.println("str1의 해시코드(변경2) : " + str1.hashCode());
		str1 = "HELLO";
		System.out.println("str1의 해시코드(변경3) : " + str1.hashCode());
		
	}
	

}
