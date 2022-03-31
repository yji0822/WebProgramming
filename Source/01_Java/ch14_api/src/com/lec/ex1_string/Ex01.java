package com.lec.ex1_string;

public class Ex01 {
	
	public static void main(String[] args) {
		
		String str1 = "Java";
		String str2 = "Java";
		// String new로 생성하지 않고 ""를  사용한 문자열  상수를 이용, 자동으로 힙 (JVM에서 자동으로 메모리 정리)
		// 자동으로 힙 영역에 String 객체가 이미 존재하는지 확인하고
		// 존재하면 이미 존재하는 문자열 객체를 공유한다. 존재하지 않는다면 String 객체를 생성한다. (new는 무조건 새로운 객체 생성)
		// String 에만 예외를 준 것임.
		String str3 = new String("Java"); // 무조건 객체 생성
		
		if (str1 == str2) {
			System.out.println("str1과 str2는 같은 주소값이 있음");
		} else {
			System.out.println("str1과 str2는 다른 주소값이 있음");
		}
		
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 문자열");
		}
		
		System.out.println(str1==str3 ? "str1과 3은 같은 주소" : "str1과 str3은 다른 주소");
		System.out.println(str1.equals(str3)? "같은 String" : "다른 문자열");
			
			
	} // main
	
}
