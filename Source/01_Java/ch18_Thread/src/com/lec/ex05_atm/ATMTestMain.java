package com.lec.ex05_atm;

public class ATMTestMain {

	public static void main(String[] args) {
		
		ATM card = new ATM(20000); // ��ü�� 2������ �ܾ�
		Runnable target = new ATM_Target(card); // Ÿ�� ������
		Thread th1 = new Thread (target, "MOM"); // ������
		Thread th2 = new Thread(target, "DAD");
		th1.start();
		th2.start();

	}

}
