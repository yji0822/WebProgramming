package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ּҸ� �Է��ϼ��� : ");
		// sc.nextLine(); �� ó���� �� ��쿡�� ������� �ʴ´�.
		String address = sc.nextLine();
		System.out.println("�Է��Ͻ� �ּҴ� " + address);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.next();
		System.out.println("�Է��Ͻ� �̸��� " + name);
		
		sc.close();
		
	}

}
