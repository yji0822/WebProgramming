package com.lec.condition;

import java.util.Scanner;

// ����ڷκ��� �� ���� �Է¹޾� ù��° ���� �� ū�� �ι�° ���� �� ū�� ���
public class Ex02_if {

	public static void main(String[] args) {
	
		int num1, num2;
		int i = 10;
		Scanner sc = new Scanner (System.in); // sc = ��ü�� Ÿ��
		
		System.out.print("ù��° �� �Է�: ");
		num1 = sc.nextInt(); // ������ �Է��ϰ� ���͸� ������ �ش� ������ num1�� �Ҵ�
		// �Է� �ް� ���� ġ�� ������ ��� ���
		System.out.print("�ι�° �� �Է�:");
		num2 = sc.nextInt();
		
		if (num1 > num2) {
			System.out.println("ù��° ���� �ι�° ������ " + (num1-num2) + "��ŭ �� Ů�ϴ�.");
		}
		else if (num1 < num2) {
			System.out.printf("�ι�° ���� %d��ŭ �� Ů�ϴ�. \n", num2-num1);
		}
		else {
			System.out.println("�Է��� �� ���� ���� ���Դϴ�.");
		}
		
		sc.close();

	}

}
