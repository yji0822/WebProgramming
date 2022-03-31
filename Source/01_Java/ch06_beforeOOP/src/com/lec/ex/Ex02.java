package com.lec.ex;
// 1~10까지의 정수의 합을 출력하고 그 합이 짝수인지 홀수인지 출력
// for문과 삼항연산자.
public class Ex02 {
	public static void main(String[] args) {
		int tot = 0;
		
		for(int i=1; i<=10; i++) {
			tot += i;
		}
		System.out.println("정수의 합은: " + tot);
		
		String msg;
		if (tot%2 == 0) {
			msg = "짝수";
		}
		else {
			msg = "홀수";
		}
		System.out.println(msg); // tot=55 - 홀수
		
		
	}

}
