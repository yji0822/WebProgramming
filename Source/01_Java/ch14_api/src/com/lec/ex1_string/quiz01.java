package com.lec.ex1_string;

import java.util.Scanner;

// �ֹι�ȣ�� �Է¹޾� �������� �������� ��� ����> 
// �ֹι�ȣ�� ��920225-2012121���������� �Է¹޴´�

public class quiz01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ֹι�ȣ�� �Է����ּ��� (�Է¹��: 950822-123456): ");
		String jumin = sc.next();
		
		if((jumin.charAt(7) == '1') || (jumin.charAt(7) == '3') ) {
			System.out.println("����� ������ ����");
			} else if (jumin.charAt(7) == '2' || (jumin.charAt(7) == '4')) {
				System.out.println("����� ������ ����");
				} else {
				System.out.println("����� �ܰ���?");
				}

				
	}
}
