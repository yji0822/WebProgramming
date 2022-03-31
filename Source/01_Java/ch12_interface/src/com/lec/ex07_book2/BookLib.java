package com.lec.ex07_book2;

public class BookLib extends BookInfo implements ILendable {
	// String borrower
	// String checkoutDate
	// byte state(0,1)
	private String borrower; // 대출인
	private String checkOutDate; // 대출일 - 나중에 연체날짜 계산할 수 있도록 바꿀 것.
	private byte state; // 따로 값을 초기화하지 않았기 때문에 기본 값은 '0'이다.
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}

	@Override
	public void checkOut(String borrower, String checkoutDate) {
		if (state == STATE_BORROWED) { // 상태 확인 - 대출 중이면 메세지 뿌리고 대출 중단
			System.out.println(borrower + "님께서 빌리시려는" + getBookTitle() + " 도서는 대출 중입니다.");
			return;
		}
		// state가 0이라 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkoutDate;
		state = STATE_BORROWED; // 대출 중 상태로 전환
		System.out.println(getBookTitle() + "도서가 대출 처리 되었습니다.");
		System.out.println("대출인 : " + borrower + "\t 대출일 : " + checkoutDate);
	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "도서는 반납 완료된 책인데.. 이상합니다. 예외처리"); // 예외처리... 나중에..
			return; // 중단
		}
		// state == 1 (대출중)이라 반납 진행
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "도서가 반납이 완료되었습니다.");
	}

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookNo() + "\t " + getBookTitle() + " (" + getWriter() + "지음) 대출 가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(getBookNo() + "\t " + getBookTitle() + " (" + getWriter()
			+ "지음) 대출 중");
		} else {
			System.out.println(getBookNo() + "\t " + getBookTitle() + " (" + getWriter() + "지음) 이상해");
		}
	}
	
	// getter & setter
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	
	

}
