package com.lec.ex1_tryCatch;
import java.util.InputMismatchException;
// 예외 처리 추가
// 발생될 수 있는 예외들 : ArithmeticException, InputMismatchException(int형에string입력했을때)
import java.util.Scanner;

public class Ex03 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int i, j=1;
		
		do{
			try {
				System.out.print("사칙연산을 할 첫번째 수 : ");
				i = sc.nextInt(); // i가 정수가 올바르게 들어가있으면 break로 빠져나오도록 하는..!
				break;
			} catch(Exception e) {// InputMismatchException e
				System.out.println("(예외 메세지) " + e.getMessage());
				System.out.println("정수를 반드시 입력하세요."); 
				sc.nextLine(); // next()로 지워주어도 된다. - 버퍼를 지우는 목적으로 작성
			}
		}while(true);
		
		System.out.print("사칙연산을 할 두번째 수 : "); // 0 을 입력하면 예외발생
		// 예외가 발생될 수 있는 부분들을 try-catch로 감싸기
		try { // 중복 try절은 사용하지 않는다.
			j = sc.nextInt();
			System.out.println("i = " + i + ", j = " + j);
			System.out.println("i X j = " + (i*j));
			System.out.println("i / j = " + (i/j));
		} catch(InputMismatchException e) {
			System.out.println("(예외메세지) " + e.getMessage());
			System.out.println("두번째 수를 잘못 입력하시면 1로 초기화 됨");
		} catch(ArithmeticException e) { // try절에 여러번 예외가 발생될 경우에는 catch문을 더 작성해준다.
			System.out.println(e.getMessage());
		} catch (Exception e) { // 슈퍼클래스로 아무 객체의 예외처리가 가능하다.
			System.out.println("(예외메세지-Exception)" + e.getMessage()); 
		}
		
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("Done");
		
		
		sc.close();
		
	}
}
