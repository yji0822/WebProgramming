package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt(); // '\n'���� ���ڸ� return
		System.out.println("�Է��Ͻ� ���� : " + age);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.next(); // String return
		// whitespace �ձ��� ���� return (space�� ���� �������� �Է¹޴� �Լ�)
		System.out.println("�Է��Ͻ� �̸� : " + name);
		
		System.out.print("�ּҸ� �Է��ϼ��� : ");
		sc.nextLine();; // ���� �Է��ϰ� ���ۿ� �����ִ� '\n'�� �����ִ� ����
		String address = sc.nextLine(); // String return
		// '\n' �տ� �ִ� ���� return�ϰ� 
		System.out.println("�Է��Ͻ� �ּҴ� : " + address); // �� string�� �� �Ͱ� ����.
		
		
		sc.close();
		
	}
	
	
}
