package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		//(Quiz4) ���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, 
		// ����ο�롱 ���, �ƴϸ� ���Ϲݡ� ���
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���̸� �Է����ּ���: ");
		int age = scanner.nextInt();
		String result = age>=65 ? "��ο��" : "�Ϲ�";
		System.out.println(result);
		
		scanner.close();
		
		

	}

}
