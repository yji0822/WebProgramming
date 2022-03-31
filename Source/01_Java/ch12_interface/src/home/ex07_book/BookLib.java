package home.ex07_book;

public class BookLib extends BookInfo implements ILendable {
	
	private String borrower; // 대출인
	private String checkOutDate; // 대출일
	private byte state; // 대출중, 대출가능
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}

	@Override 
	public void checkOut(String borrower, String checkOutDate) { // 대출
		if(state == STATE_BORROWED) {
			System.out.println(getBookTitle() + "도서는 대출 중입니다.");
			return;
		}
		// 대출처리진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(getBookTitle() + "도서가 대출 처리 되었습니다.");
		System.out.println("대출인 : " + borrower + "\t 대출일: " + checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "도서는 반납완료된 책인데 이상합니다. 예외다!!!");
			return;
		}
		// state가 대출중이라 반납 진행
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "도서가 반납 완료 되었습니다.");
	}

	@Override
	public void printState() {
		if(state==STATE_NORMAL) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + "지음) 대출가능");
		}else if(state==STATE_BORROWED) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + "지음) 대출중");
		}else {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + "지음) 이상해");
		}
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
