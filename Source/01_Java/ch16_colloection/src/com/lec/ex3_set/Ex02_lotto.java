package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Random;
//import java.util.TreeSet;

public class Ex02_lotto {

	public static void main(String[] args) {
		
		// �������
//		int[] lotto = new int[6];
		// HashSet ���
		HashSet<Integer> lotto = new HashSet<Integer>();
//		TreeSet<Integer> lotto = new TreeSet<Integer>();
		
		// ������ü ����Ͽ� size�� 6������ Ȯ���� �Ѵ�.
		Random random = new Random();
//		while(lotto.size() < 6) {
//			lotto.add(random.nextInt(45)+1); // 1~45������ ���� ���� add
//		}
//		System.out.println(lotto); // �ߺ��� ���� ������ �ʴ´�!
		
		// ��� ������ ��ȣ�� ����ߴ��� Ȯ�� - �󸶳� �ߺ��ƴ��� Ȯ�ο�
		int cnt = 0;
		while(lotto.size() < 6) {
			cnt++;
			lotto.add(random.nextInt(45)+1); // 1~45������ ���� ���� add
		}
		System.out.println(cnt + "�� ���� �̾� ���� �ζ� ���� : " +lotto); // �ߺ��� ���� ������ �ʴ´�!

		
	}

}
