package com.lec.ex;

public class Ex04_multiDimensional {

	public static void main(String[] args) {
		// 다차원배열 - 2차원 배열
		int[] arr = {1,2,3};
		int[][] arr1 = {{1, 2, 3},
						{4, 5, 6}}; //2행 3열의 2차원 배열
		
		// 출력
		System.out.println(arr[2]); // 3 - 3번째 인덱스
		System.out.println(arr1[1][0]); // 4 - 2행1열 인덱스
		
		// 다차원 배열 출력
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.printf("test[%d][%d] = %d \n", i, j, arr1[i][j]);
			} // for - j
		} // for - i

		
	} // main

} // class
