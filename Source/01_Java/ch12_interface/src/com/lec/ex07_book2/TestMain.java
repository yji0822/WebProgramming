package com.lec.ex07_book2;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		
		System.out.println("0324 실습예제_도서대출 프로그램");
		BookLib[] books = {new BookLib("890ㅁ-101-1ㄱ", "java", "홍길동"),
						   new BookLib("110ㄱ-111-1ㄱ", "dbms", "신길동"),
					       new BookLib("110ㅁ-123-2ㅌ", "web", "유길동"),
						   new BookLib("770ㅁ-123-3ㅌ", "jsp", "고길동"),
						   new BookLib("110ㅁ-123-2ㄹ", "spring", "김길동") };
		
		Scanner sc = new Scanner (System.in);
		int fn; // 기능번호 (1. 대출 | 2. 반납 | 3. 책List | 0. 종료)
		int idx; // 대출하거나 반납하려고 할 때, 조회된 책의 index - 반복문에서 객체만들면 조회 안된다
		String bTitle, borrower, checkOutDate; // 사용자에게 받을 책 이름, 대출인, 대출일
		do { // 반드시 한번은 실행
			System.out.print("1. 대출 | 2. 반납 | 3. 책List | 0. 종료  ");
			fn = sc.nextInt();
			switch(fn) {
			case 1:
				// 대출 : 1. 책 이름 입력 2.책 조회  3.책상태 확인 4.대출인 입력 5.대출일 입력 6.대출 메소드 
				// 1. 책이름입력
				System.out.print("대출하고자 하는 책 이름 : ");
				bTitle = sc.next(); // string 받는 함수 - 띄어쓰기를 포함받지 않음 / white-space 앞까지의 스트링만 받음
				// 2.책조회
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				// 책 대여 상태 조회 for
				if(idx==books.length) {
					System.out.println("현재 보유하지 않은 도서 입니다.");
				} else { // books[idx] 도서를 대출 처리
					// 3. 책상태 확인
					if(books[idx].getState() == BookLib.STATE_BORROWED) { // 대출불가 상태
						System.out.println("현재 대출 중인 도서입니다.");
					} else { // 대출 가능 상태
						// 4. 대출인입력 5. 대출일 입력 6. 대출 메소드 호출
						System.out.print("대출자 : ");
						borrower = sc.next();
						System.out.print("대출일 : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2: // 반납 : 1.책이름 2. 책조회 3. 반납
				System.out.print("반납할 책 이름 : ");
				bTitle = sc.next();
				// 2. 책조회
				// 인덱스를 받아올 수 없으므로 확장for문 사용은 하지 않는다.
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
				} else { // idx가 찾은 그 위치
					// 3. 반납
					books[idx].checkIn();
				}
				break;
			case 3: 
				System.out.println("책 리스트는 다음과 같습니다.");
				for (BookLib b : books) {
					b.printState();
				}
				break;
				
			} // switch-case
		} while(fn!=0);
		System.out.println("BYE");

		
	} // main

} // class
