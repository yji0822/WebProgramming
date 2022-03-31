package com.lec.ex;
// ** 삼항연산자  -  (조건) ? (참일경우 취할 값/식) : (거짓일경우 취할 값/식)
public class Ex06 {

	public static void main(String[] args) {
		int h = 100;
		String result;
		
		System.out.println("조건문 if");
		if(h%2 == 0) {
			result = "짝수";
		}
		else {
			result = "홀수";
		}
		System.out.println(result);
		
		System.out.println("삼항연산자");
		result = (h%2==0) ? "짝" : "홀";
		
		System.out.println(result);

		
	}

}
