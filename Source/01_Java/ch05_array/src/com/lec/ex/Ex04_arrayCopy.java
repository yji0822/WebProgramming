package com.lec.ex;
// api�� �̿��� �迭 ���� ** System.arraycopy(�����迭, ��������idx, ���纻�迭, ���纻����idx, �迭�氳��)
// ���� �迭���� �κи� �������� ���� ��쿡...!
public class Ex04_arrayCopy {

	public static void main(String[] args) {		
		int[] score = {100, 10, 20, 30, 40}; // 5���� ���� �ִ� score��� �迭����
		int[] s = new int[score.length]; // score�� ����  ũ���� ���ο� 5���� �� ����
		
		System.arraycopy(score, 0, s, 0, score.length);
		
		s[0] = 999; // s�� �� ����.
		
		for (int idx=0; idx<score.length; idx++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", idx, score[idx], 
					idx, s[idx]);
		} // ������ ����		
		

	}
}
