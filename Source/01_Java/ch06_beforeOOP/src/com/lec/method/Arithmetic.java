package com.lec.method;
// 수학적인 내용이 들어가있는 class 모음
public class Arithmetic {

	public int abs(int value) { // static 없는 함수가 99%
		int result = (value>=0) ? value : -value; // 가독성 높은 삼항연산자
//		if(value >=0) {
//			result = value;
//		} else {
//			result = -value;
//		}
		return result;
	}
	
	public static int sum(int to) { // 함수의 오버로딩
		int result = 0;
		for(int i=1; i<=to; i++) {
			result += i;
		}
		return result;
	} // public or private가 없으면 같은 패키지 안에서만 사용가능 
	// 반드시 작성해주어야 하는 부분!
	
	public static String evenOdd(int value) { 
		return value%2==0 ? "짝수!" : "홀수";
	}
	
	public static int sum(int from, int to) {
	// static - 메인함수에서 바로 쓰려고
		int result = 0;
		for(int i=from; i<=to; i++) {
			result += i; // result = result + i;
		}
		return result; 
	}
	

}
