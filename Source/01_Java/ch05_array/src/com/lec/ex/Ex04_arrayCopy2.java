package com.lec.ex;
// for문을 이용한 배열 복사
public class Ex04_arrayCopy2 {

	public static void main(String[] args) {		
		int[] score = {100, 10, 20, 30, 40}; // 5개의 방이 있는 score라는 배열변수
		int[] s = new int[score.length]; // score과 같은  크기의 새로운 5개의 방 생성
		
		for(int idx=0; idx<score.length; idx++) {
			s[idx] = score[idx];
		} // score배열의 값을 s배열에 넣어주는 것! - 복사개념
	
		s[0] = 999; // s만 값 변경.
		
		for (int idx=0; idx<score.length; idx++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", idx, score[idx], 
					idx, s[idx]);
		} // 값변경 성공
		
		// 전후처리 작업할때 자주 사용한다.
		

	}
}
