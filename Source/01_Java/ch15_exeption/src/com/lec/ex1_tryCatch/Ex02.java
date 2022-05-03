package com.lec.ex1_tryCatch;
// ���ܰ� �߻��� �� �ִ� ���� ����ó��  - tryExeption
import java.util.Scanner;

public class Ex02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("��Ģ������ �� ù��° �� : ");
		int i = sc.nextInt();
		System.out.print("��Ģ������ �� �ι�° �� : "); // 0 �� �Է��ϸ� ���ܹ߻�
		int j = sc.nextInt();
		
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i*j));
		try {
		System.out.println("i / j = " + (i/j)); // ���ܰ� �߻��� �� �ִ� �κ�
		} catch(Exception e) { // ArithmeticException �� ����Ŭ������, Exeption�� ���൵ ����
			// ���ܰ� �߻��� ��� ��ȸ������ ������ ���� �ۼ�
			System.out.println("���ܸ޼���: " +e.getMessage()); // ���ܰ� �߻��Ǹ� ���� �޼��� �߻� (���ܸ޼����� ���)
//			e.printStackTrace(); // ���ܻ����� �ڼ��� ���
		}
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		
		sc.close();
		
	}
}
