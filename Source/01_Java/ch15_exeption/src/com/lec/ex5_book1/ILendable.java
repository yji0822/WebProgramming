package com.lec.ex5_book1;

public interface ILendable {
	
	public static final byte STATE_BORROWED = 1; // 책상태 1(대출중=대출불가) 0(대출가능)
	public byte STATE_NORMAL = 0; // 대출 가능
	public void checkOut(String borrower) throws Exception; // 대출인만 입력 - 예외는 반드시 이곳에 입력
	public void checkIn() throws Exception; // 반납했는데 반납한다고 하면 예외처리
	
}
