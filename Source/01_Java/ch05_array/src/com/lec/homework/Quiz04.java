package com.lec.homework;
// ������ ���� 4) �Ž����� 2680�� 500, 100, 50, 10¥�� �������� �� ��, ��� �־�� �ϳ�?
public class Quiz04 {

	public static void main(String[] args) {
		int[] coin = {500, 100, 50, 10};
		int money = 2680;
			
		for (int index=0; index<coin.length; index++) {
			System.out.println(coin[index] + "�� " + money/coin[index] + "��");
			money %= coin[index];
		} // for
		

	}

}
