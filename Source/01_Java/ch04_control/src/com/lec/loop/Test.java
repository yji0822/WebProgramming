package com.lec.loop;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// [문2] 구축된 개발 환경에서 원하는 구구단 수를 입력받아 해당 구구단을 출력하는 자바 프로그램을 구현하시오.
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("<< 구구단 출력 프로그램 >>");
		System.out.print("출력하고 싶은 단을 입력해주세요 : ");
		int num = sc.nextInt();
	
		
		for (int i=1; i<=9; i++) {
			System.out.println(num + " X " + i + " = " + (num*i));
		}
		
		sc.close();

	}

}
