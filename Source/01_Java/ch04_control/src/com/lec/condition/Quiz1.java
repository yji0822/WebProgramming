package com.lec.condition;
// (�ǽ�����1) ���� �Է¹޾� ���밪�� ����ϴ� ���α׷�
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("���밪 ��� ���α׷�");
		System.out.print("���ڸ� �Է����ּ���: ");
		int num = sc.nextInt();
		
		if (num > 0) {
			System.out.println(num +"�� ���밪�� " + num);
		}
		else if (num < 0) {
			System.out.println(num + "�� ���밪�� " + -num);		
		}
		else {
			System.out.println("�Է��Ͻ� ���ڴ� 0�Դϴ�.");
		}
		
		
		sc.close();
		
	}

}
