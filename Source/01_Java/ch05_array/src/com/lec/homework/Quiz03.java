package com.lec.homework;

public class Quiz03 {

	public static void main(String[] args) {
		// ������ ����3) 76, 45, 34, 89, 100, 50, 90, 92 
		// 8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ�� ��� �׸��� �ִ밪�� �ּҰ��� ���Ͻÿ�.
		
		int[] arr = {76, 45, 34, 89, 100, 50, 90, 92};
		int sum = 0, avg; // ��, ���
		
		// �迭 ���
		System.out.print("int[] arr  =    ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		// ����
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("����: " + sum);
		
		// ���
		avg = sum / arr.length;
		System.out.println("���: " + avg);
		
		// �ִ�, �ּ�
		int max = 0;
		int min = 999;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			} // if - max
			if(arr[i] < min) {
				min = arr[i];
			} // if - min
		} // for
		System.out.println("�ִ밪: " + max);
		System.out.println("�ּҰ�: " + min);

	}

}
