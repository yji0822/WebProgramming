package com.lec.ex;

public class Ex03_reference {

	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		j = 99;
		System.out.printf("i = %d, j = %d \n", i, j);
		// j���� �ٲ�ٰ� i���� �ٲ��� �ʴ´�.
		
		// �迭�� �ٲ��...! ����?
		int[] score = {100, 10, 20, 30, 40}; // 5���� ���� �ִ� score��� �迭����
		int[] s = score;
		s[0] = 99;
		for (int idx=0; idx<score.length; idx++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", idx, score[idx], 
					idx, s[idx]);
		} // s�� ���� �ٲ�µ� score���� ���� ���ع��� �� Ȯ��.
		// ���� �ּҰ��� ����ϱ� ������ ���� ���ϴ� ���� ����!
		// score���� �ּҰ� 9999, s�� score �ּҰ��� �־����Ƿ� �ּҰ� �����ϰ� 9999
		
		

	}

}
