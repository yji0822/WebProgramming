package com.lec.condition;

import java.util.Scanner;

// (Quiz 4) ����(0)����(1)��(2) �� �ϳ��� ���� �� ���� ����ϼ���
public class Quiz4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); // ��ü���� sc 
		System.out.print("����(0) ����(1) ��(2) �� �ϳ��� �����ϼ���: ");
		int num = sc.nextInt();
		
		if (num == 0) {
			System.out.println("����");
		}
		else if (num == 1) {
			System.out.println("����");
		}
		else if (num == 2) {
			System.out.println("��");
		}
		else {
			System.out.println("�߸� �Է��߽��ϴ�.");
		}
		
		sc.close();		
		
	}
}
