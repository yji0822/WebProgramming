package com.lec.ex05_atm;
// ATM a = new ATm(10000)
public class ATM {
	
	private int balance;

	// 생성자
	public ATM(int balance) {
		this.balance = balance;
	}
	
	// 메소드
	// 입금
	public synchronized void deposit(int amount, String who) {
		System.out.println(who + "가 입금 시작~~");
		balance += amount;
		System.out.println(who + "가 " + amount + "원 입금하여 잔액: " + balance );
		System.out.println(who + "가 입금 종료!!!");
	}
	// 출금
	public synchronized void withdraw(int amount, String who) {
		System.out.println(who + "가 출금 시작 @@@@");
		balance -= amount;
		System.out.println(who + "가 " + amount + "원 출금하여 잔액: " + balance);
		System.out.println(who + "가 출금 종료!!!");
	}

	public int getBalance() {
		return balance;
	}
	
	

}
