package com.lec.ex;

import java.util.Scanner;

// 5. ����ڷκ��� ���� �Է� �޾� ���밪�� ����ϴ� ������ �����Ͻÿ� (��, �Ű������� �޾� ���밪�� �����ϴ� �Լ�(=�޼ҵ�)�� �̿��մϴ�.
public class Quiz02_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է�: ");
		int user = sc.nextInt();
		abs(user);
		
		sc.close();	
	} // main
	
	private static int abs(int num) {
		if (num>=0) {
			System.out.println(num + "�� ���밪�� " + num + "�Դϴ�.");
			return num;
		}
		else {
			System.out.println(num + "�� ���밪�� " + (-num) + "�Դϴ�.");
			return num;
		}
	} // abs
	
	

}
