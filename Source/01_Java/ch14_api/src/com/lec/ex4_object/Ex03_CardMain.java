package com.lec.ex4_object;

public class Ex03_CardMain {

	public static void main(String[] args) {
		
		Card [] cards = { new Card('��', 1),
				          new Card('��', 2),
				          new Card('��', 3),
				          new Card('��', 4) };
		
		for(Card card : cards) {
			System.out.println(card);
		}
		
		Card comCard = new Card('��', 4);
		System.out.println("��ǻ���� " + comCard);
		
		if(cards[3].equals(comCard)) {
			System.out.println("�� ī��� ��ġ �մϴ�.");
		} else {
			System.out.println("�� ī��� ����ġ �մϴ�.");
		} // equals �������̵�!!!! �ؾ���
		

	}

}
