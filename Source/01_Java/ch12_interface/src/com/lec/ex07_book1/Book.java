package com.lec.ex07_book1;
// Book b = new Book("890ㅁ-101-1ㄱ", "java", "홍길동")
public class Book implements ILendable {
	
	// 데이터
	private String bookNo; // 책번호 890ㅁ-101-1ㄱ
	private String bookTitle; // 책제목
	private String writer; // 저자
	private String borrower; // 대출인
	private String checkOutDate; // 대출일 - 나중에 연체날짜 계산할 수 있도록 바꿀 것.
	private byte state; // 대출중(1=STATE_BORROWED) 대출가능(0=STATE_NORMAL)
	
	// 생성자
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null;
//		checkOutDate = null;
//		state = STATE_NORMAL == 0; // 대출 가능
	}
	
	// b.checkOut("신길동", "03-23"); 대출중 : state(상태) 확인해서 대출 중이면 대출 중단 / 대출 가능이면 대출 처리
// 	@Override
//	public void checkOut(String borrower, String checkoutDate) {
//		if (state == STATE_BORROWED) { // 상태 확인 - 대출 중이면 메세지 뿌리고 대출 중단
//			System.out.println(borrower + "님께서 빌리시려는" + bookTitle + " 도서는 대출 중입니다.");
//		} else { // 대출 처리
//			this.borrower = borrower;
//			this.checkOutDate = checkoutDate;
//			state = STATE_BORROWED; // 대출 중 상태로 전환
//			System.out.println(bookTitle + "도서가 대출 처리 되었습니다.");
//			System.out.println("대출인 : " + borrower + "\t 대출일 : " + checkoutDate);
//		}
//	}
 	@Override
	public void checkOut(String borrower, String checkoutDate) {
		if (state == STATE_BORROWED) { // 상태 확인 - 대출 중이면 메세지 뿌리고 대출 중단
			System.out.println(borrower + "님께서 빌리시려는" + bookTitle + " 도서는 대출 중입니다.");
			return;
		}
		// state가 0이라 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkoutDate;
		state = STATE_BORROWED; // 대출 중 상태로 전환
		System.out.println(bookTitle + "도서가 대출 처리 되었습니다.");
		System.out.println("대출인 : " + borrower + "\t 대출일 : " + checkoutDate);
	}

 	// b.checkIn() 반납 : state 확인해서 대출 가능 (0)이면 메세지 뿌리고 중단, 대출중이면(1) 반납 진행
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle + "도서는 반납 완료된 책인데.. 이상합니다. 예외처리"); // 예외처리... 나중에..
			return; // 중단
		}
		// state == 1 (대출중)이라 반납 진행
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "도서가 반납이 완료되었습니다.");
	}

	// 책상태 출력 b.printState() => 890ㅁ-101-1ㄱ java(홍길동 著) 대출 중
	@Override
	public void printState() { // 대출 가능인지 아닌지 상태 확인
		// 1
		if(state == STATE_NORMAL) {
			System.out.println(bookNo + "\t " + bookTitle + " (" + writer + "지음) 대출 가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(bookNo + "\t " + bookTitle + " (" + writer + "지음) 대출 중");
		} else {
			System.out.println(bookNo + "\t " + bookTitle + " (" + writer + "지음) 이상해");
		}
		
		// 2 같은 로직! 원하는거 사용하면 됨
//		String msg = bookNo + "\t " + bookTitle + "(" + writer + "지음)";
//		msg = msg + (state == STATE_NORMAL ? "대출 가능" : (state==STATE_BORROWED) ? "대출 중" : "이상혀"); // state 
//		System.out.println(msg);
	}

	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
	


	
}
