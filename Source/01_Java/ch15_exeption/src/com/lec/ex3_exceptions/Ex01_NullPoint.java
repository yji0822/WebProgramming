package com.lec.ex3_exceptions;

public class Ex01_NullPoint {

	public static void main(String[] args) {
		
		String greeting = "Hello";
		System.out.println(greeting.toUpperCase()); // ��� �빮�ڷ�
		greeting = null;
		System.out.println(greeting.toUpperCase());

	}

}
