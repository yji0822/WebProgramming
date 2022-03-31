package com.lec.ex3_math;

import java.util.Random;

// �ζǹ�ȣ 6�� �̱�
public class Ex05_lotto {

	public static void main(String[] args) {
			
		int[] lotto = new int[6]; // �ζǶ�� ������ 6���� �� ����
		Random random = new Random();
		
		for(int idx=0; idx<lotto.length; idx++) {
//			lotto[i] = (random.nextInt(45)+1);
			int temp = random.nextInt(45)+1; // ���� ������ �ӽ� ������ �����ϰ�
			boolean ok = true; // ���� ������ �ߺ��� �ƴ� ��� true / �ߺ��� ��� false
			for(int i=0; i<idx; i++) {
				if(temp == lotto[i]) { // ���� ������ �ߺ��̴� �ٽ� �̾ƾ� ��
					idx--;
					ok = false;
					break;
				}
			} // for: �߻��� ������ ���� �չ濡 ����Ǿ������� Ȯ��(�ߺ��� �������� Ȯ��)
			if(ok) { // ok = true���
				lotto[idx] = temp;
			}
		} // for 
		
		for(int i=0; i<lotto.length; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					// i��°�� j��° ������ ũ�� �ڸ��� �ٲپ� �ش�.
					int temp = lotto[i]; // �ӽ÷� �����ϴ� ����
					lotto[i] = lotto[j];
					lotto[j] = temp;
				} // if
			}// for j - �������� ���ķ���
		} // for i - �������� ���ķ���
		
		for(int l : lotto) {
			System.out.print(l + "\t");
		} // ���
		
		
		
	} // main

}
