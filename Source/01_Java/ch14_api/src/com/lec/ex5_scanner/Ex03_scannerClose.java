package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex03_scannerClose {

	public static void main(String[] args) {
		// BookLib ��ü ���� ����ڿ��� ���� or �ݳ�
		Scanner scMain = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = scMain.nextLine();
		System.out.println("�Է��Ͻ� �̸��� " + name + "�Դϴ�.");
		
		nickName();
		
		System.out.print("���� : ");
		int age = scMain.nextInt();
		System.out.println("�Է��Ͻ� ���̴� " + age + "�Դϴ�.");
		
		
		scMain.close();
		
	}
	
	private static void nickName() { // ����ڷκ��� ������ �޾� ����ϴ� �޼ҵ�
	// static���� ȣ���� �Լ��� �ݵ�� static�̾�� �Ѵ�.
		Scanner scNickName = new Scanner(System.in);
		System.out.print("���� : ");
		System.out.println("�Է��Ͻ� ������ " + scNickName.nextLine());
		// ���� ���۸� ����ϰ� �ֱ� ������ �� �ʱ�ȭ�� �����־ �ȴ�.
//		scNickName.close();
		
	}
	
}
