package com.lec.ex;

public class Ex03_reference {

	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		j = 99;
		System.out.printf("i = %d, j = %d \n", i, j);
		// j값이 바뀐다고 i값이 바뀌진 않는다.
		
		// 배열은 바뀐다...! 왜지?
		int[] score = {100, 10, 20, 30, 40}; // 5개의 방이 있는 score라는 배열변수
		int[] s = score;
		s[0] = 99;
		for (int idx=0; idx<score.length; idx++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", idx, score[idx], 
					idx, s[idx]);
		} // s의 값만 바꿨는데 score값도 같이 변해버린 것 확인.
		// 같은 주소값을 사용하기 때문에 같이 변하는 것이 맞음!
		// score에도 주소가 9999, s에 score 주소값을 넣었으므로 주소가 동일하게 9999
		
		

	}

}
