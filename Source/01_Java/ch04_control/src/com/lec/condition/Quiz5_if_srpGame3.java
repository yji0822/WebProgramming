package com.lec.condition;

import java.util.Scanner;

public class Quiz5_if_srpGame3 {

	public static void main(String[] args) {
		// ���������� ����
		
		Scanner sc = new Scanner (System.in);
		
		int you;
		int computer = (int)(Math.random()*3); // 3���� �������� ����� ��
		
		System.out.print("������ 0, ������ 1, ���� 2��  �Է����ּ��� : ");
		you = sc.nextInt();
		if (you==0) {
			System.out.println("you ���� \t");
		}
		else if (you == 1) {
			System.out.println("you ���� \t");
		}
		else if (you == 2) {
			System.out.println("you �� \t");
		}
		else {
			System.out.println("�߸� �Է��߽��ϴ�.");
			you = 3;
		}
		
		if(you != 3) { // ���� ���
			// ���׿����� ** ����!!!
			String msg = (computer == 0) ? "com ����" : (computer == 1) ? "com ����" : "com ��";
			System.out.println(msg);
		}

	}

}
