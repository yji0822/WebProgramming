package com.lec.ex;

import java.util.Scanner;

// 5. ����ڷκ��� ���� �Է� �޾� ���밪�� ����ϴ� ������ �����Ͻÿ� (��, �Ű������� �޾� ���밪�� �����ϴ� �Լ�(=�޼ҵ�)�� �̿��մϴ�.
public class Quiz02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է�: ");
		int user = sc.nextInt();
		System.out.println(user + "�� ���밪: " + abs(user));
		
		sc.close();
			
	}
	
	private static int abs(int user) {
		/* if (user>=0) {
			return user;
		}
		else {
			return -user;
		} */
		return user>=0 ? user : -user;

	}
	
	

}
