package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {

	public static void main(String[] args) {
		//(Quiz 5) ����, ����, ���� ������ ������ �Ҵ��ϰ� �� ������ ����ϰ� 
		// ����, ���(�Ҽ���2�ڸ�����) ����ϴ� ���α׷��� ���� �Ͻÿ�
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� ���� �Է�: ");
		int kor = scanner.nextInt();
		System.out.print("���� ���� �Է�: ");
		int eng = scanner.nextInt();
		System.out.print("���� ���� �Է�: ");
		int math  = scanner.nextInt();
		
		int sum = kor+eng+math;
		double avg = (double)sum/3.0;
		
		System.out.printf("����: %d��, ���: %.2f�� ", sum,avg); 
		// %.2f �Ҽ��� �ι�° �ڸ����� �ݿø�
		
		scanner.close();
		

	}

}
