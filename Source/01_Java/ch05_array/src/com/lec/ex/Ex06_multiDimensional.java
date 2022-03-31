package com.lec.ex;
// 배열은 1차원 배열 가장 많이 사용함. 해도 2차원 정도? 데이터 베이스에 넣는
// pdf 7페이지
public class Ex06_multiDimensional {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3}; // 1차원 배열
		int[][] test = { {1,2,3},
						 {4,5,6} }; // 2행3열의 2차원 배열
		System.out.println(arr[2]); // 0~2번 index - for문 1개
		System.out.println(test[0][0]); 
		// (test[행][열]) 0~1행 0~2열 - 중첩for문
		
//		for(int i=0; i<2; i++) { // i = 0~1행
//			for(int j=0; j<3; j++) {
//				System.out.printf("test[%d][%d] = %d \n", i, j, test[i][j]);
//			} // for -j
//		} // for -i

		for(int i=0; i<test.length; i++) { // 행 - 2
		for(int j=0; j<test[i].length; j++) { // 열 - 3
			System.out.printf("test[%d][%d] = %d \n", i, j, test[i][j]);
		} // for -j
	} // for -i
		
	}

}
