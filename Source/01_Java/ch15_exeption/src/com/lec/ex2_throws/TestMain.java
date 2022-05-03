package com.lec.ex2_throws;

public class TestMain {

	public static void main(String[] args) {
		
		try { // 메인함수에서는 throws하고 던져주기 보다 그냥 try catch문을 사용해주는 것이 좋다.
			new ThrowsEx(); // 생성자 호출
		} catch (Exception e) {
			System.out.println("(error msg) " + e.getMessage());
		} 
		
	}

}
