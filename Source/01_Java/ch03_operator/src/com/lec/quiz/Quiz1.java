package com.lec.quiz;

import java.util.Scanner;

// (Quiz1) 3�� ��� ���� �Ǵ��ϱ�  = ���� Ǯ��!!
// : ����ڷκ��� ���ڸ� �Է� �ް�, �Է� ���� ���ڰ� 3�� ������� �ľ�

public class Quiz1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Scanner.. ����ڷκ��� �Է��� �޴� ��.
		System.out.println("3�� ��� Ȯ�� ���α׷�");
		System.out.print("���ڸ� �Է��ϼ���: ");
		int su = scanner.nextInt(); // ����ڷκ��� �Է¹ޱ� (���͸� ���������� ���)
		String result = su%3 == 0 ? "3�� ���!!" : "3�� ��� X";
		System.out.println(result);
		
		scanner.close();

	}

}
