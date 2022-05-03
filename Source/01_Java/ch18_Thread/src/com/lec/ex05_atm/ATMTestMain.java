package com.lec.ex05_atm;

public class ATMTestMain {

	public static void main(String[] args) {
		
		ATM card = new ATM(20000); // 객체에 2만원의 잔액
		Runnable target = new ATM_Target(card); // 타겟 오브제
		Thread th1 = new Thread (target, "MOM"); // 스레드
		Thread th2 = new Thread(target, "DAD");
		th1.start();
		th2.start();

	}

}
