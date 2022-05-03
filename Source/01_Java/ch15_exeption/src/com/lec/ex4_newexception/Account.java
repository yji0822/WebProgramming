package com.lec.ex4_newexception;

public class Account {
	
	private String accountNo;
	private String ownerName;
	private int    balance;
	
	// 생성자
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	// 메소드
	// deposit - 예금 전 계좌정보 출력 -> 예금 -> 예금 후 계좌정보 출력
	public void deposit(int amount) { // Account a = new Account ("1-1", "홍", 100)
									  // Sysout ("예금 전: " + a);
									  // a.deposit(100) -> deposit함수 내에서는 this가 a
		System.out.println("예금 전 : " + this);
		balance += amount; // balance = balance + amount; // 예금
		System.out.println(amount + "원 예금 후 : " + this);
	}
	
	// 출금 : 출금 전 계좌정보 출력 -> 출금 -> 출금 후 계좌정보 출력
	public void withdraw(int amount) throws Exception {
		if(balance < amount) { // 잔액 부족으로 출금되지 않음 : 강제
			throw new Exception(amount + "원 출금하기에는 잔액("+balance+")이 부족합니다."); 
			// ** 잔액보다 더 많은 금액을 출력하고 싶을 때 예외 객체가 만들어지면서 호출한 곳으로 감
		}
		System.out.println("출금 전 : " + this);
		balance -= amount; // balance = balance-amount;
		System.out.println(amount + "원 출금 후 : " + this);
	}
	
	@Override
	public String toString() {
		return "계좌번호 : " + accountNo + "\t예금주 : " + ownerName + "\t잔액: " + balance;
	}
	
	

}
