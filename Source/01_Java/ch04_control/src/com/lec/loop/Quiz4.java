package com.lec.loop;
// 퀴즈 ④ 다음과 같은 출력 형식의 구구단을 출력하는 프로그램을 구현해 보자
public class Quiz4 {
	public static void main(String[] args) {
		
		for (int i=1; i<=9; i++) { // 행
			for (int j=2; j<=9; j++) { // 열
				System.out.print(j + " X " + i + " = " + (i*j) + "\t");
				// System.out.printf("%d * %d = %d \t", j, i, j*i);
			} // for j
			System.out.println(); // 개행
		} // for i
		
		
	}
}

