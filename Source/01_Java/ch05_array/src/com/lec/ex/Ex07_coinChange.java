package com.lec.ex;
// �Ž����� 2680���� 500��, 100��, 50��, 10��¥�� �������� �Ž��� �� ��, 
// ���� ��� �־�� �ϴ��� ����Ͻÿ�.
public class Ex07_coinChange {

	public static void main(String[] args) {
		
		int[] coin = {500, 100, 50, 10};
		int money = 2680;
		
		for(int i=0; i<coin.length; i++) {
			System.out.print(coin[i] + "�� ¥�� " + (money/coin[i]) + "�� \t");
		}


	}

}
