package com.lec.ex;
// �迭�� 1���� �迭 ���� ���� �����. �ص� 2���� ����? ������ ���̽��� �ִ�
// pdf 7������
public class Ex06_multiDimensional {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3}; // 1���� �迭
		int[][] test = { {1,2,3},
						 {4,5,6} }; // 2��3���� 2���� �迭
		System.out.println(arr[2]); // 0~2�� index - for�� 1��
		System.out.println(test[0][0]); 
		// (test[��][��]) 0~1�� 0~2�� - ��øfor��
		
//		for(int i=0; i<2; i++) { // i = 0~1��
//			for(int j=0; j<3; j++) {
//				System.out.printf("test[%d][%d] = %d \n", i, j, test[i][j]);
//			} // for -j
//		} // for -i

		for(int i=0; i<test.length; i++) { // �� - 2
		for(int j=0; j<test[i].length; j++) { // �� - 3
			System.out.printf("test[%d][%d] = %d \n", i, j, test[i][j]);
		} // for -j
	} // for -i
		
	}

}
