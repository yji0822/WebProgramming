package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		// (Quiz 2) �Է��� ���� ¦������ Ȧ������ ���
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է��ϼ���: ");
		int num = scanner.nextInt();
		String result = num%2==0 ? "¦��!" : "Ȧ��!";
		System.out.println(result);
		
		scanner.close();

	}

}
