package com.lec.homework;

public class Quiz02 {

	public static void main(String[] args) {
		// ������ ���� 2) 2���� �迭�� ����� ���� �հ踦 ���Ͻÿ�
		int[][] arr = { {5,   5,  5,  5,  5}, 
						{10, 10, 10, 10, 10}, 
						{20, 20, 20, 20, 20}, 
						{30, 30, 30, 30, 30} };
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sum += arr[i][j];
			} // for - j ��
		} // for - i ��
		System.out.println(sum);

		
	}

}
