package com.lec.ex;

public class Ex04_multiDimensional {

	public static void main(String[] args) {
		// �������迭 - 2���� �迭
		int[] arr = {1,2,3};
		int[][] arr1 = {{1, 2, 3},
						{4, 5, 6}}; //2�� 3���� 2���� �迭
		
		// ���
		System.out.println(arr[2]); // 3 - 3��° �ε���
		System.out.println(arr1[1][0]); // 4 - 2��1�� �ε���
		
		// ������ �迭 ���
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.printf("test[%d][%d] = %d \n", i, j, arr1[i][j]);
			} // for - j
		} // for - i

		
	} // main

} // class
