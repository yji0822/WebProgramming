package com.lec.loop;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// [��2] ����� ���� ȯ�濡�� ���ϴ� ������ ���� �Է¹޾� �ش� �������� ����ϴ� �ڹ� ���α׷��� �����Ͻÿ�.
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("<< ������ ��� ���α׷� >>");
		System.out.print("����ϰ� ���� ���� �Է����ּ��� : ");
		int num = sc.nextInt();
	
		
		for (int i=1; i<=9; i++) {
			System.out.println(num + " X " + i + " = " + (num*i));
		}
		
		sc.close();

	}

}
