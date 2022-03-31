package com.lec.ex3_math;

import java.util.Random;

// �ζǹ�ȣ 6�� �̱�
public class Ex04 {

	public static void main(String[] args) {
		/* �迭����
		 * 1. ũ�� ����
		 * 2. ���� X 
		 * 3. �ߺ����� X
		 * �迭 ���� - arrayList - Java Collection Ʈ���� �ڷᱸ��
		 */
		
		int[] lotto = new int[6]; // �ζǶ�� ������ 6���� �� ����
		Random random = new Random();
		
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (random.nextInt(45)+1);
		} // for // �ߺ��� �ζǹ�ȣ�� �߻��� �� �ִ�. - ����¥�� �ڵ�
		
		for(int i=0; i<lotto.length; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					// i��°�� j��° ������ ũ�� �ڸ��� �ٲپ� �ش�.
					int temp = lotto[i]; // �ӽ÷� �����ϴ� ����
					lotto[i] = lotto[j];
					lotto[j] = temp;
				} // if
			}// for j - �������� ���ķ���
		} // for i
		
		for(int l : lotto) {
			System.out.print(l + "\t");
		} // ���
		
		
		
	} // main

}
