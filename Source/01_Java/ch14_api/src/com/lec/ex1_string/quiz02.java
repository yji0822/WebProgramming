package com.lec.ex1_string;
// ����. �ݺ������� ��ȭ��ȣ�� �Է¹޾� ������ ���� ������ ����ϴ� �ݺ������� �����Ͻÿ�. 
// ��ȭ��ȣ ��� x�� �Է��ϸ� �����մϴ�
/*String tel;
while(){
  // ��ȣ(031-234-5678)�Է� �ϸ� (sc.next())
	"�Է��� ��ȭ��ȣ : 031-234-5678
	 ¦����° ���ڿ�  : 0 1 2 4 5 7
	���ڸ� ���ٷ�    : 8765-432-130
	��ȭ��ȣ �Ǿ��ڸ���: 031
	��ȭ��ȣ ���ڸ���: 5678"�� sysout
  // x(X)�� �Է��ϸ� ���α׷� ��
} */

import java.util.Scanner;

public class quiz02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
	
		String num;
		do {
			System.out.print("��ȭ��ȣ�� �Է����ּ��� (���Ḧ ���ϸ� X�� �����ּ���): ");
			num = sc.next();
			System.out.print("�Է��� ��ȭ��ȣ : " + num + "\n");
			
		} while(!num.equalsIgnoreCase("x"));
		System.out.println("done");
		
	}

}
