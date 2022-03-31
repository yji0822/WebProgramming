package com.lec.ex14_account;
// CheckingAccount a2 = new CheckingAccount 
// ("11-11", "홍길동", 2000, "1111-1111-2222-3333")
// a2.pay("1111-1111-2222-3333", 1000);
public class CheckingAccount extends Account {

	// 데이터
	private String cardNo;
	
	// 생성자
	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		// 잔액은 0
		super(accountNo, ownerName); // 부모클래스에 존재
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		// 잔액 존재
		super(accountNo, ownerName, balance); // 부모클래스에 존재
		this.cardNo = cardNo;
	}
	
	
	// 메소드
	// a2.pay("1111-1111-2222-3333", 1000);
	// void pay() 
	// String cardNo - 내가 가지고 있는 카드 금액과 같은지 확인 먼저
	// int amount - 내가 얼마나 긁혔는지 (잔액이 크거나 같아야 출력되도록)
	public void pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) { // cardNo.equals(this.cardNo) 해도 무방
			if(getBalance() >= amount) {
				setBalance(getBalance() - amount); // balance -= amount;
				System.out.printf("%s(%s)님, %d원 지불하여 잔액 %d원 남았습니다. \n"
						, getOwnerName(), getAccountNo(), amount, getBalance());
			} else {
				System.out.printf("%s(%s)님 잔액 %d원으로 %d원 지불 불가 합니다. \n"
				, getOwnerName(), getAccountNo(), getBalance(), amount);
			} // if-else 지불 가능
		} else {
			System.out.println("올바른 카드 번호를 입력하세요.");
		} // if-else 카드번호 확인
	}// pay
	
	// getter&setter
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
} // class
