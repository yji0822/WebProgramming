package com.lec.homework;

public class Quiz01 {

	public static void main(String[] args) {
		// ������ ����1) �迭�� ��� ���� ���ϴ� ���α׷��� �ۼ�
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		
		
		// ���� ���̴� ���
		System.out.println();
		sum = 0;
		for(int temp : arr) {
			sum += temp;
		}
		System.out.println("total : " + sum);

	}

}
