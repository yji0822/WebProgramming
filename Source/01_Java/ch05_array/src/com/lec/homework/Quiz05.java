package com.lec.homework;

import java.util.Arrays;

public class Quiz05 {
	public static void main(String[] args) {
		
		int[] arr = {76, 45, 34, 89, 100, 50, 90, 92};
		// ���縦 ���־�� �Ѵ�.
		int[] sortArr = new int[arr.length];
		
		for (int i=0; i<arr.length; i++) {
			sortArr[i] = arr[i];
		} // arr�� ����
		
		// for������ sort(����) �ϴ� ��
		// 1. ��������
		// Arrays.sort(sortArr);
		for (int i=0; i<sortArr.length; i++) { // i = 0~7����
			for(int j=i+1; j<sortArr.length; j++) { // j = i+1~7����
				// i��°�� j��° ���ؼ� i��°�� ũ�� ��ġ ��ȯ
				if(sortArr[i] > sortArr[j]) {
					// ���ǻ���: ���� �����ع����� ���� ���� ������� ������ 
					// �� ���� ������ ������ �ϳ� ������־�� �Ѵ�.
					int temp = sortArr[i];
					sortArr[i] = sortArr[j]; // j�� ������ ���� �Ǵ�
					sortArr[j] = temp;
				} // if
			} // for - j
		} // for - i
		System.out.print("���� ������ : ");
		for(int temp : arr) {
			System.out.print(temp + " ");
		}
		System.out.print("\n�������� ������ : ");
		for(int temp : sortArr) {
			System.out.print(temp + " ");
		}
		

//		Arrays.sort(arr);
//		for(int temp : arr) {
//			System.out.printf("%d \t" ,temp);
//		}
		
			
	}

}
