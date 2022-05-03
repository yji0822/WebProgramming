package com.lec.ex2_throws;

public class ThrowsEx {
	
	// 생성자
	public ThrowsEx() throws Exception {
		actionC();
	}
	
	private void actionC() throws Exception {
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}
	
	private void actionB() throws RuntimeException {
		System.out.println("actionB 전반부");
//		try{ // 호출한 곳에서 예외처리
			actionA();
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("(예외메세지) " + e.getMessage());
//		}
		System.out.println("actionB 후반부");
	}
	
	private void actionA() throws ArrayIndexOutOfBoundsException { 
		// 예외가 발생된 순간 그 밑에 것들은 실행되지 않고 메소드 종료 후 예외를 호출한 곳으로 예외를 던진다.
		System.out.println("actionA 전반부");
		int[] arr = {0,1,2,3};
		System.out.println(arr[4]); // 인위적인 예외발생
		System.out.println("actionA 후반부");
	}
	
}
