package com.lec.ex07_book1;
// Book 작업명세 (한테 넘길 것.)
public interface ILendable {
	public byte STATE_BORROWED = 1; // "대출 중"
	public byte STATE_NORMAL   = 0; // "대출 가능"
	// static final 상수 
	public void checkOut(String borrower, String checkoutDate); // 대출 시 대출인과 대출일 이용
	public void checkIn(); // 반납
	public void printState(); // 도서정보와 대출상태 출력
	
	
}
