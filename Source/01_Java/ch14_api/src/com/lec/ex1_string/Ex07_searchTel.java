package com.lec.ex1_string;

import java.util.Scanner;

// �迭�� �ִ� ��ȭ��ȣ ã�Ƽ�  ��ü ��ȭ��ȣ ��� (��ȭ��ȣ ���ڸ� �Է¹޾Ƽ�)
public class Ex07_searchTel {
	
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999", "010-8888-8888", "010-7777-8888"};
		Scanner sc = new Scanner(System.in);
		String searchTel; // ����ڷκ��� ���ڸ� ��ȭ��ȣ �Է¹��� ������ �Ҵ� 
		boolean searchOk = false;
		System.out.print("�˻��ϰ��� �ϴ� ȸ���� ��ȭ��ȣ ���ڸ���?");
		searchTel = sc.next(); // ���ڸ� �Է� ex1234
		for(int idx=0; idx<tels.length; idx++) {
			// idx��°�� ��ȭ��ȣ ���ڸ� ����
			String post = tels[idx].substring(tels[idx].lastIndexOf('-')+1); // �Ǹ����� - ������ �ε��� �� �������� ���!
			// post searchTel ��
			if(post.equals(searchTel)) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ�� " + tels[idx] + "�Դϴ�.");
//				break;
				searchOk = true;
			} // if- �´� ��ȭ��ȣ�� �迭 �ȿ��� ã�� ��� �� �̻� �˻����� �ʰ� for�� ����
		} // for
		if(! searchOk) { // searchTel�� �迭 ��ȭ�� ��� ��ã�� idx�� ������ �� ���
			System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�.");
		}
		
		sc.close();
		
		
	} // main

}
