package com.lec.loop;
// 퀴즈 ③ 5단 구구단을 출력해보자
public class Quiz3 {

	public static void main(String[] args) {
		
		int num = 5;
		for (int i=1; i<=9; i++) {
			System.out.println(num + " X " + i + " = " + (num*i));
			// System.out.printf("5 * %d = %d \n", i, 5*i);
		}

		
	}

}
