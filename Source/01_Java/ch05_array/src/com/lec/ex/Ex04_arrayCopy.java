package com.lec.ex;
// api를 이용한 배열 복사 ** System.arraycopy(원본배열, 원본시작idx, 복사본배열, 복사본시작idx, 배열방개수)
// 원본 배열에서 부분만 가져오고 싶을 경우에...!
public class Ex04_arrayCopy {

	public static void main(String[] args) {		
		int[] score = {100, 10, 20, 30, 40}; // 5개의 방이 있는 score라는 배열변수
		int[] s = new int[score.length]; // score과 같은  크기의 새로운 5개의 방 생성
		
		System.arraycopy(score, 0, s, 0, score.length);
		
		s[0] = 999; // s만 값 변경.
		
		for (int idx=0; idx<score.length; idx++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", idx, score[idx], 
					idx, s[idx]);
		} // 값변경 성공		
		

	}
}
