package com.lec.ex4_newexception;

public class AccountTestMain {

	public static void main(String[] args) {
		Account obj1 = new Account("111-111", "홍길동"); // 계좌 0원 - 1원이라도 출금 원할 시 예외 객체 호출
		Account obj2 = new Account("111-222", "신길동", 2000); // 계좌 2000원
		obj1.deposit(1000);
		obj2.deposit(1000);
		try {
			obj1.withdraw(500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // withdraw 메소드 선언 시, throws가 있으면 호출시에도 try-catch를 해주어야 한다.
		
		try {
			obj2.withdraw(30000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	} // main

}
