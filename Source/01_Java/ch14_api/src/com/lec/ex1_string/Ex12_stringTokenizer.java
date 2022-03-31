package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenizer {
	
	public static void main(String[] args) {
		String str1 = "박보검 설현 수지 고소영 장동건";
		String str2 = "2022/03/28";
		
		StringTokenizer tokenizer1 = new StringTokenizer(str1); // space 기준으로  문자열을 분할해준다.
		System.out.println("tokenizer1의 토큰 개수 : " + tokenizer1.countTokens()); // 토큰의 개수를 반환해줌

		while (tokenizer1.hasMoreTokens()) { // 토큰이 더 남아있으면 
			System.out.println(tokenizer1.nextToken()); // 다음 토큰을 출력하는 함수
		} // while
	
		StringTokenizer tokenizer2 = new StringTokenizer(str2, "/"); // '/'기준으로 문자를 분할한다.
		System.out.println("tokenizer2의 토큰 개수 : " + tokenizer2.countTokens());
		while (tokenizer2.hasMoreTokens()) { // 다음 토큰이 존재한다면
			System.out.println(tokenizer2.nextToken()); // 다음 토큰을 출력하는 함수
		}
		
	
	} // main

}
