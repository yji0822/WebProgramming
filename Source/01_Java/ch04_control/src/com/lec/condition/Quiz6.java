package com.lec.condition;

import java.util.Scanner;

// (Quiz 6) ���� ��������� Ű����κ��� �Է¹޾� ����� ����ϴ� ���α׷��� �����ϼ���
// Api �̿� / ���� ������� �ý��ۿ��� �ҷ��ͼ� ����� ����� �� �ִ�! ***
public class Quiz6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("���� �Է��ϼ���: ");
		int month = sc.nextInt();
		
		switch(month) {
		case 12: case 1: case 2:
			System.out.println("Winter, �ܿ�");
			break;
		case 3: case 4: case 5:
			System.out.println("Spring, ��");
			break;
		case 6: case 7: case 8:
			System.out.println("Summer, ����");
			break;
		case 9: case 10: case 11:
			System.out.println("Fall, ����");
			break;
		default:
			System.out.println("����");
		}
		
		sc.close();

	}

}
