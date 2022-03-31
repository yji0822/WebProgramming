package com.lec.ex4_object;

import java.util.Random;

// comCard�� ����ī�� �����Ͽ� �迭 �� 0~������� ��ġ�ϴ��� ����ġ �ϴ��� �����س���.
public class Ex03_CardMain2 {

	public static void main(String[] args) {
		
		Card [] cards = { new Card('��', 1),
				          new Card('��', 2),
				          new Card('��', 3),
				          new Card('��', 4) };
		
		for(Card card : cards) {
			System.out.println(card);
		}
		
		Random random = new Random();
		char[] kinds = {'��', '��', '��', '��'};
		Card comCard = new Card(kinds[random.nextInt(4)], random.nextInt(13)+1);
		System.out.println("��ǻ�Ͱ� �����ϰ� ������ ī�� : " + comCard);
		
		if(cards[3].equals(comCard)) {
			System.out.println("�� ī��� ��ġ �մϴ�.");
		} else {
			System.out.println("�� ī��� ����ġ �մϴ�.");
		} // equals �������̵�!!!! �ؾ���
		
		for(int idx=0; idx<cards.length; idx++) {
			if(cards[idx].equals(comCard)) {
				System.out.println(idx + "��° ī��� ��ġ!!!!");
			} else {
				System.out.println(idx + "��° ī��� ����ġ..");
			}
		}

	}

}
