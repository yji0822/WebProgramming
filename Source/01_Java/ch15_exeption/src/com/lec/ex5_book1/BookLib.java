package com.lec.ex5_book1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {

	// data
	private String bookNo; // 책 번호
	private String bookTitle; // 책제목
	private String writer; // 저자
	private String borrower; // 대출인
	private Date   checkOutDate; // 대출일-시스템으로부터 입력 받는.
	private byte   state; // 대출가능=1=STATED_BORROWED, 대출불가능=0;
	
	// 생성자
	public BookLib(String bookNo, String bookTitle, String writer) {
//		super(); 오브젝트 클래스에서의 슈퍼 생성자 가지고 오는 것
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	// method
	// BookLib book = new BookLib("89a-01", "java", "홍길동");
	// book.checkOut("신길동"); : 도서상태 확인 -> 대출로직 -. 도서상태 출력
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state == STATE_BORROWED) {
			throw new Exception(bookTitle + "도서는 대출 중 입니다."); 
			// error msg. 강제로 예외 발생 - 반드시 try-catch 해주어야
		}
		// 대출로직 실행 - if문을 통과하지 못하고 밑으로 내려온 것
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		// "java" 도서가 대출되었습니다. 대출인: 신길동 대출일: 2022-04-04(월) 2주 이내에 반납하세요. 메세지 출력
		// 날짜를 원하는 형태로 출력하기 위해서는...SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)"); // 데이터 출력 형식 익숙해지기
		System.out.println("\"" + bookTitle + "\" 도서가 ☆★대출☆★ 되었습니다.");
		System.out.println("대출인 : " + borrower + " / 대출일: " + sdf.format(checkOutDate) + " 2주 내로 반납하세요.");
	}
	
	// book.checkIn() : 도서상태확인 -> 연체여부 확인(연체료) > if. 연체되었을 경우 연체료 납부 y/n -> 반납로직 -. 상태출력 
	// checkoutDate와 현재 날짜를 비교를 해서 14일 이전; 반납 진행 / 14일 이후; 연체료 발생
	@Override
	public void checkIn() throws Exception {
		if(state == STATE_NORMAL) {
			throw new Exception(bookTitle + "도서는 대출 중이 아니에요."); // 예외메세지 발생
		}
		// 연체여부 확인 checkOutDate ~ 현재까지 14일 이내인지 확인
		// 특정한 시점 == checkOutDate
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime(); // 대출시점부터 현재까지의 millsec 빼줘서 대출기간 확인 
		long day = diff / (1000*60*60*24);
		// 연체여부
		if(day > 14) { // 14일 경과 (연체), 연체료 출력
			System.out.println("연체료는 일일 100원 부과됩니다.내셔야 할 연체료는 " + (day-14)*100 + "원 입니다.");
			Scanner sc = new Scanner (System.in); 
			// 연체가 안되면 Scanner가 필요하기 때문에 이곳에 작성 - main함수에서 반드시 닫아주자
			System.out.print("연체료를 내셨나요? (Y/N) ");
			if(! sc.next().equalsIgnoreCase("y")) { // Y/y를 입력하지 않은 경우
				System.out.println("연체료를 내셔야 반납처리가 가능합니다. 연체료를 내세요.");
				return; // void기때문에 그냥 return. 나를 호출한 곳으로 돌아가야 한다.
			}
		} 
		// 반납 로직
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "\" 도서가 ☆★반납☆★되었습니다.");
	}
	
	// sysout(book) -> 책번호:89a-01 책이름:java 저자: 홍길동 대출 가능
	// 				-> 책번호:89a-01 책이름:java 저자: 홍길동 대출 중(대출일: 2022-04-04(월)) / 반납 예정일:빌린날짜 +14일
	@Override
	public String toString() {
		String msg = "책번호: " + bookNo + "\t책이름: " + bookTitle + "\t저자: " + writer; 
		msg += (state == STATE_NORMAL) ? "\t\"대출 가능\"" : "\t\"대출 중\"";
		if(state == STATE_BORROWED) { // 반납 예정일을 계산 해주어야 한다.
//			Date date = new Date(checkOutDate.getTime() + (1000*60*60*24*14)); // 반납예정일
			SimpleDateFormat sdf = new SimpleDateFormat("(대출일 : yyyy-MM-dd(E))");
			msg += sdf.format(checkOutDate);
		}
		return msg;
	} // toString()


	// 대출일 날짜 조작
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
}

