package com.lec.ex6_wrapper;

import java.util.Scanner;

// ����ڷκ��� ���� ���ڿ�("100")�� �Է� �޾� ������ �����ؼ� ����ϴ� ���α׷�
// id�Է��Ҷ� space�Էµ� ���� �����ִ� ��
public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("����(int num)�� �Է��ϼ��� : ");
		int num = sc.nextInt();
		System.out.println("�Է��Ͻ� ������ " + num);

		System.out.print("����(String numStr)�� �Է��ϼ��� : ");
		sc.nextLine(); // �ʱ�ȭ
		String numStr = sc.nextLine(); // �ٸ� ���ڰ� ���� ���� �ִ�.
		numStr = numStr.trim(); // *** ���� ��� *** �¿� �����̽��� ���ŵȴ�.(numStr�� �ִ� ���� ����)
//		numStr = numStr.replace("��", ""); - ���̶� �ܾ� �ϳ��� ����� �Ǵ� ����
		numStr = numStr.replaceAll("[a-zA-Z��-�R]", ""); // ���� ����
		int num1 = Integer.parseInt(numStr); 
		// �����̽��� ��string���� ������ �����߻� - String�� Integer�� �ٲ��ִ� �Լ� / ���ڿ��� �Է¹޾��� ��� ���� �߻�
		System.out.println("�Է��Ͻ� ���ڿ��� " + numStr);
		
	}

}
