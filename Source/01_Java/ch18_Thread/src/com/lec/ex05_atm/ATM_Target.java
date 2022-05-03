package com.lec.ex05_atm;
// ATM card = new ATM(20000);
// ATM_Target target = new ATM_Target(card);
public class ATM_Target implements Runnable {

	private boolean flag; 
	private ATM card;
	
	public ATM_Target(ATM card) {
		this.card = card;
	}
	
	// 입금을 시작하면 입금 종료까지 접근 불가
	@Override
	public void run() {
		// 저금했다가 출금했다가 - 5회 실행 예정
		for(int i=0; i<10; i++) { // 플래그 작업
			if(flag) { // 출금
				card.withdraw(1000, Thread.currentThread().getName()); // 스레드이름이 a이면 1000원 출금하고 flag false로 변환 
				flag = false;
			} else { // 저금
				card.deposit(1000, Thread.currentThread().getName());
				flag = true;
			} // if
		} // for
	} // run

}
