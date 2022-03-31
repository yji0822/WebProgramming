package com.lec.quiz;

import java.util.Scanner;

// (Quiz1) 3의 배수 숫자 판단하기  = 같이 풀음!!
// : 사용자로부터 숫자를 입력 받고, 입력 받은 숫자가 3의 배수인지 파악

public class Quiz1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Scanner.. 사용자로부터 입력을 받는 것.
		System.out.println("3의 배수 확인 프로그램");
		System.out.print("숫자를 입력하세요: ");
		int su = scanner.nextInt(); // 사용자로부터 입력받기 (엔터를 누를때까지 대기)
		String result = su%3 == 0 ? "3의 배수!!" : "3의 배수 X";
		System.out.println(result);
		
		scanner.close();

	}

}
