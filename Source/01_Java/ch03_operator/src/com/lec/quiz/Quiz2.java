package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		// (Quiz 2) 입력한 수가 짝수인지 홀수인지 출력
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요: ");
		int num = scanner.nextInt();
		String result = num%2==0 ? "짝수!" : "홀수!";
		System.out.println(result);
		
		scanner.close();

	}

}
