package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		// (Quiz 3) �μ��� �Է¹޾� �� ���� ������ ����� O�� X�� ���.
		// ù��° ���� �� ū�� ����� O�� X�� ����Ѵ�.
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("����1�� �Է��ϼ���: ");
		int num1 = scanner.nextInt();
		System.out.print("����2�� �Է��ϼ���: ");
		int num2 = scanner.nextInt();
		
		String result1 = num1==num2 ? "O" : "X";
		System.out.println("���� ��? " + result1);
		
		String result2 = num1 > num2 ? "O" : "X";
		System.out.println("ù��° ���� �� ū ��? " + result2);
 		
		scanner.close();

	}

}
