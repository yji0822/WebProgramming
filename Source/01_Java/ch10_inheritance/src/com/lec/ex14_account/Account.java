package com.lec.ex14_account;
/* 데이터 (속성, 멤버변수(인스턴스변수)) 
 * : 계좌번호 (accountNo: String), 예금주 (ownerName: String), 잔액 (balance: long)	
 * 기능 (메소드) 
 * : 예금하다 (void deposit(int)),인출하다 (int withdraw(int)), 잔액조회 (long infoPrint() -getter?) 
 * Account a = new Account(); - 디폴트 생성자 
 * Account a = new Account("100-1", "홍길동");
 * 			 = new Account("100-2", "홍길동", 20000)*/

public class Account {
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주
	private long balance; // 잔액
	
	// 생성자 함수 3개
	public Account() {} // 디폴트 생성자
	public Account(String accountNo, String ownerName) { // 생성자 역할 : 데이터 초기화
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s(%s)님 계좌 개설 감사합니다. 돈은 왜 안갖고 오셨어요? \n", ownerName, accountNo);
	} // 초기 입금 금액 안들고 온 사람의 계좌 개설 생성자
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s(%s)님 계좌 개설 완료. %d 원 입금 완료되었습니다. \n", 
				ownerName, accountNo, balance); // long 타입도 %d로 적어준다.
	} // 계좌, 예금주, 입금금액 생성자
	
	
	// 메소드 deposit, withdraw, infoPrint
	public void deposit(int money) { // 예금은 양수 money가 들어오면 예금처리
	// 저금할 금액만 넣기 때문에 void
		if(money >= 0) {
			balance += money;
			System.out.printf("%s(%s)님, %d원 입금 완료 되었습니다. 현재 잔액: %d \n",
								ownerName, accountNo, money, balance);
		} else {
			System.out.println("장난금지");
		}
	}
	public void withdraw(int money) {
		if(money <= balance) {
			balance -= money;
			System.out.printf("%s(%s)님, %d원 출금 완료 되었습니다. 현재 잔액: %d \n",
					ownerName, accountNo, money, balance);
		} else {
			System.out.println(ownerName + " 님 출금 잔액 부족하여 인출이 불가합니다.");
		} // if-else
	}
	public String infoPrint() { // 홍길동(100-1)님 잔액: 1000원
		return String.format("%s(%s)님 잔액 : %d원", ownerName, accountNo, balance); // **
//		return ownerName + "("+ accountNo +")" +"님 잔액 : " + balance + "원";
	}
	
	
	// getter & setter
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
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}	
		
	

}
