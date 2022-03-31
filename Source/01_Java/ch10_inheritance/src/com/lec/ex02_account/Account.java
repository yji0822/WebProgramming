package com.lec.ex02_account;
/* 데이터(속성, 멤버변수(인스턴스변수))
 * 계좌번호 String accountNo, 예금주 String ownerName, 잔액 int balance
 * 기능 (메소드)
 * 예금 void deposit(int), 인출 int withdraw(int), 잔액조회 int infoPrint()
 */
public class Account {

	// 데이터
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주
	private int balance; // 잔액
	
	// 생성자
	public Account() {
	}
	public Account(String accountNo, String ownerName) { // 계좌개설, 돈입금X
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.println(ownerName + "(" + accountNo + ")님, 계좌개설 감사합니다. 입금금액은 없습니다.");
	}
	public Account(String accountNo, String ownerName, int balance) { // 계좌개설, 돈입금O
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName + "(" + accountNo +")님, 계좌개설 완료." + balance + "원 입금 완료.");
	}
	
	// 메소드- 입금, 출금, 출력
	public void deposit(int money) {
		if(money >= 0) {
			balance += money;
			System.out.println(ownerName + "(" + accountNo + ")님, " + money + "원 입금 완료. 현재잔액: " + balance + "원");
		} else {
			System.out.println(ownerName + "님?? 장난금지");
		} // if
	} // deposit
	
	public void withdraw(int money) {
		if(money <= balance) {
			balance -= money;
			System.out.println(ownerName + "(" + accountNo + ")님" + money + "원 인출 완료. 현재잔액: " + balance + "원");
		} else {
			System.out.println(ownerName + "님, 출금 잔액이 부족하여 인출이 불가합니다.");
		} //if		
	} // withdraw
	
	public String infoPrint() {
		return String.format("%s(%s)님 잔액: %d원", ownerName, accountNo, balance);
	}
	
	// getter&setter
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}
