package com.lec.ex1_tryCatch;
// 예외처리 전
import java.util.Scanner;

public class Ex01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("사칙연산을 할 첫번째 수 : ");
		int i = sc.nextInt();
		System.out.print("사칙연산을 할 두번째 수 : "); // 0 을 입력하면 예외발생
		int j = sc.nextInt();
		
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i*j));
		System.out.println("i / j = " + (i/j));
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		
		sc.close();
		
	}
}
