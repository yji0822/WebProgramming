package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		// (Quiz 3) 두수를 입력받아 두 수가 같은지 결과를 O나 X로 출력.
		// 첫번째 수가 더 큰지 결과를 O나 X로 출력한다.
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자1을 입력하세요: ");
		int num1 = scanner.nextInt();
		System.out.print("숫자2를 입력하세요: ");
		int num2 = scanner.nextInt();
		
		String result1 = num1==num2 ? "O" : "X";
		System.out.println("같은 값? " + result1);
		
		String result2 = num1 > num2 ? "O" : "X";
		System.out.println("첫번째 수가 더 큰 값? " + result2);
 		
		scanner.close();

	}

}
