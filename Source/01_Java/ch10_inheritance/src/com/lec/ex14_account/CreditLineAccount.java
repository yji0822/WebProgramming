package com.lec.ex14_account;
// CreditLineAccount c2 = new CreditLineAccount("11-11", "홍", "1111-2222-3333-4444", 10000);
// CreditLineAccount c3 = new CreditLineAccount("11-11", "홍", 1000, "1111-2222-3333-4444", 10000);
public class CreditLineAccount extends CheckingAccount {

	private int creditLine; // 카드한도 
	
	// 생성자
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	} // 잔액이 0원인 생성자
	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	} // 잔액추가하는 생성자
	
	// 오버라이드 메소드
	@Override
	public void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) { // cardNo.equals(this.cardNo) 해도 무방
			if(creditLine >= amount) {
				creditLine -= amount; 
				System.out.printf("%s(%s)님, %d원 지불하여 한도 금액 %d원 남았습니다. \n"
						, getOwnerName(), getAccountNo(), amount, creditLine);
			} else {
				System.out.printf("%s(%s)님 남은 한도 금액 %d원으로 %d원 지불 불가 합니다. \n"
				, getOwnerName(), getAccountNo(), creditLine, amount);
			} // if-else 한도 계산
		} else {
			System.out.println("올바른 카드 번호를 입력하세요.");
		} // if-else 카드번호 확인
	}

}
