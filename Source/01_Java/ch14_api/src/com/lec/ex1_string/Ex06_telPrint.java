package com.lec.ex1_string;

import java.util.Scanner;

// ��ȭ��ȣ �޾�, �Է¹��� ��ȭ��ȣ, ¦����° ����, �Ųٷ�, ��ȭ��ȣ ���ڸ�, ��ȭ��ȣ ���ڸ�
// jsp ���� �� �ٷ�� ������ �ѹ� �� �غ���!
public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String tel;
		
		do {	// while(true) break ����ؼ� �� �غ���..!
			System.out.print("��ȭ��ȣ�� �Է��ϼ��� (���� : 010-9898-1234)");
			tel = sc.next(); // string �Է� - �����̽��� �ȵȴ�!
			System.out.println("�Է��� ��ȭ��ȣ�� : " + tel);
		System.out.print("¦����° ���ڿ� : ");
		for(int i=0; i<tel.length(); i++)
			if(i%2 == 0) {
				System.out.print(tel.charAt(i)); // ¦����° ���� ���
			} else {
				System.out.print(' ');
			}
		System.out.println(); // ����
		
		System.out.print("���ڸ� �Ųٷ� ��� : ");
		for(int i=tel.length()-1; i>=0; i--) {
			System.out.print(tel.charAt(i));
		}
		System.out.println();
		
		int first = tel.indexOf('-'); // ù��° '-'�� ������ �ε���
		int last = tel.lastIndexOf('-'); // ������ '-'�� ������ �ε���
		
//		tel.indexOf('-'); //-�� ���° ������
		String pre = tel.substring(0, first); // ��ȭ��ȣ ���ڸ� ��� '010'		
		System.out.println("���ڸ� : " + pre); // 010 substring indexof

		String post = tel.substring(tel.lastIndexOf('-')+1); // ��ȭ��ȣ ���ڸ� ��� '7890' ������° ('-') ���� 7��°���� ������ ����ϱ�
		System.out.println("���ڸ� : " + post); // 7890
		
		String mid = tel.substring(first+1, last);
		System.out.println("�߰��ڸ� : " + mid);
		
		} while(! tel.equalsIgnoreCase("x"));
		System.out.println("done");
		
		
		sc.close();
		
	}
}
