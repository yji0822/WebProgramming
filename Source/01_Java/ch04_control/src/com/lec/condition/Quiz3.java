package com.lec.condition;

import java.util.Scanner;

// (�ǽ�����3) ����ڷκ��� ����, ����, ���� ������ �Է¹޾� �� ���� ������ ��� �̻����� �������� ����� ����
public class Quiz3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("���� ���� �Է�: ");
		int kor = sc.nextInt();
		System.out.print("���� ���� �Է�: ");
		int eng = sc.nextInt();
		System.out.print("���� ���� �Է�: ");
		int math = sc.nextInt();
		double avg = (kor+eng+math)/3.0;
		
		// ����
		if(kor>avg) {
			System.out.println("���������� ��� �̻��Դϴ�.");
		}
		else if(kor<avg) {
			System.out.println("���������� ��� �����Դϴ�.");
		}
		else {
			System.out.println("���������� ����Դϴ�.");
		}
		
		// ����
		if(eng>avg) {
			System.out.println("���������� ��� �̻��Դϴ�.");
		}
		else if (eng<avg) {
			System.out.println("���������� ��� �����Դϴ�.");
		}
		else {
			System.out.println("���������� ����Դϴ�.");
		}
		
		// ����
		if (math>avg) {
			System.out.println("���� ������ ��� �̻��Դϴ�.");
		}
		else if (math<avg) {
			System.out.println("���������� ��� �����Դϴ�.");
		}
		else {
			System.out.println("���� ������ ��� �Դϴ�.");
		}
		
		sc.close();
		

	}

}
