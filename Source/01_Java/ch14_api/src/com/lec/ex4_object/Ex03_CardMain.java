package com.lec.ex4_object;

public class Ex03_CardMain {

	public static void main(String[] args) {
		
		Card [] cards = { new Card('◆', 1),
				          new Card('◆', 2),
				          new Card('◆', 3),
				          new Card('◆', 4) };
		
		for(Card card : cards) {
			System.out.println(card);
		}
		
		Card comCard = new Card('◆', 4);
		System.out.println("컴퓨터의 " + comCard);
		
		if(cards[3].equals(comCard)) {
			System.out.println("두 카드는 일치 합니다.");
		} else {
			System.out.println("두 카드는 불일치 합니다.");
		} // equals 오버라이드!!!! 해야함
		

	}

}
