package com.lec.ex1_tryCatch;
// 예외가 발생될 수 있는 것을 예외처리  - tryExeption
import java.util.Scanner;

public class Ex02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("사칙연산을 할 첫번째 수 : ");
		int i = sc.nextInt();
		System.out.print("사칙연산을 할 두번째 수 : "); // 0 을 입력하면 예외발생
		int j = sc.nextInt();
		
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i*j));
		try {
		System.out.println("i / j = " + (i/j)); // 예외가 발생할 수 있는 부분
		} catch(Exception e) { // ArithmeticException 의 슈퍼클래스로, Exeption만 써줘도 무방
			// 예외가 발생할 경우 우회적으로 수행할 로직 작성
			System.out.println("예외메세지: " +e.getMessage()); // 예외가 발생되면 예외 메세지 발생 (예외메세지만 출력)
//			e.printStackTrace(); // 에외사항을 자세히 출력
		}
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		
		sc.close();
		
	}
}
