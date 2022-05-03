package com.lec.ex5_book1;

import java.util.Date;

public class TestMain {

	public static void main(String[] args) {

		BookLib book1 = new BookLib("89a-01", "java", "홍길동");
		BookLib book2 = new BookLib("89a-02", "dbms", "이디비");
		System.out.println("1. 책 리스트");
		System.out.println(book1);
		System.out.println(book2);
		System.out.println("\n2. 대출 진행 ===");
		try {
			book1.checkOut("김빌림"); // 예외처리한 함수. 반드시 main에서 try-catch해주기
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 에러메시지 출력
		} 
		System.out.println(book1);
		
		// 대출일 조작
		System.out.println("\n3. 대출일 3월 11일로 변경");
		book1.setCheckOutDate(new Date(122,2,11)); // 대출일을 3월11일로 날짜 변경
		System.out.println(book1);
		try {
			book1.checkIn(); // 예외처리한 함수
		} catch (Exception e) {
			System.out.println("예외메세지 : " + e.getMessage());
		} 

		
	} // main

}
