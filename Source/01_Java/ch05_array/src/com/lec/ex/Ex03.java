package com.lec.ex;

public class Ex03 {

	public static void main(String[] args) {
		// 레퍼런스
		int[] score = {100, 10, 20, 30, 40}; // 5개의 방이 있는 score라는 배열변수
		int[] s = score; // score를 s에 대입(주소저장)
		s[0] = 99; // 0번째 변수를 99로 값변경
		
		// [1] 배열 복사
		System.out.println("[1] 배열복사");
		for(int i=0; i<score.length; i++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", i, score[i], i, s[i]);
		} // score배열과 s배열 출력 확인 
		// - s[0] 값을 바꿨지만 score[0] 값도 변경된 것을 확인할 수 있음.
		// int[] score와 int[] s가 같은 주소값을 사용하기 때문에 같이 변경된 것! 
		
		// [2] 배열 복사 후 값 변경.
		System.out.println("\n[2] 배열 복사 후 값 변경");
		int[] score1 = {100, 10, 20, 30, 40};
		int[] s1 = new int[score.length];
		
		for(int i=0; i<score1.length; i++) {
			s1[i] = score1[i];
		} // score 배열의 값을 s배열에 복사
		
		s1[0] = 1000;
		
		for(int i=0; i<score1.length; i++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", i, score1[i], i, s1[i]);
		} // 출력
		
		// 전처리 작업할때 사용한다.
		

	}

}
