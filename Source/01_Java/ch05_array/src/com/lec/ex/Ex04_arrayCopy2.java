package com.lec.ex;
// for���� �̿��� �迭 ����
public class Ex04_arrayCopy2 {

	public static void main(String[] args) {		
		int[] score = {100, 10, 20, 30, 40}; // 5���� ���� �ִ� score��� �迭����
		int[] s = new int[score.length]; // score�� ����  ũ���� ���ο� 5���� �� ����
		
		for(int idx=0; idx<score.length; idx++) {
			s[idx] = score[idx];
		} // score�迭�� ���� s�迭�� �־��ִ� ��! - ���簳��
	
		s[0] = 999; // s�� �� ����.
		
		for (int idx=0; idx<score.length; idx++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", idx, score[idx], 
					idx, s[idx]);
		} // ������ ����
		
		// ����ó�� �۾��Ҷ� ���� ����Ѵ�.
		

	}
}
