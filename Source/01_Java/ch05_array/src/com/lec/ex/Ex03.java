package com.lec.ex;

public class Ex03 {

	public static void main(String[] args) {
		// ���۷���
		int[] score = {100, 10, 20, 30, 40}; // 5���� ���� �ִ� score��� �迭����
		int[] s = score; // score�� s�� ����(�ּ�����)
		s[0] = 99; // 0��° ������ 99�� ������
		
		// [1] �迭 ����
		System.out.println("[1] �迭����");
		for(int i=0; i<score.length; i++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", i, score[i], i, s[i]);
		} // score�迭�� s�迭 ��� Ȯ�� 
		// - s[0] ���� �ٲ����� score[0] ���� ����� ���� Ȯ���� �� ����.
		// int[] score�� int[] s�� ���� �ּҰ��� ����ϱ� ������ ���� ����� ��! 
		
		// [2] �迭 ���� �� �� ����.
		System.out.println("\n[2] �迭 ���� �� �� ����");
		int[] score1 = {100, 10, 20, 30, 40};
		int[] s1 = new int[score.length];
		
		for(int i=0; i<score1.length; i++) {
			s1[i] = score1[i];
		} // score �迭�� ���� s�迭�� ����
		
		s1[0] = 1000;
		
		for(int i=0; i<score1.length; i++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", i, score1[i], i, s1[i]);
		} // ���
		
		// ��ó�� �۾��Ҷ� ����Ѵ�.
		

	}

}
