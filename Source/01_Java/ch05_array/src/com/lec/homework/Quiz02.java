package com.lec.homework;

public class Quiz02 {

	public static void main(String[] args) {
		// 오늘의 문제 2) 2차원 배열에 저장된 값의 합계를 구하시오
		int[][] arr = { {5,   5,  5,  5,  5}, 
						{10, 10, 10, 10, 10}, 
						{20, 20, 20, 20, 20}, 
						{30, 30, 30, 30, 30} };
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sum += arr[i][j];
			} // for - j 열
		} // for - i 행
		System.out.println(sum);

		
	}

}
