package com.lec.quiz01_0407;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Friend[] friends = { new Friend("ȫ�浿", "010-9999-1234", "����� ��걸", "05-22"),
				             new Friend("�ű浿", "010-8888-1234", "��⵵ ����", "04-29"),
				             new Friend("��浿", "010-7777-1234", "�λ�� ������", "06-05"),
				             new Friend("��浿", "010-7777-1234", "�λ�� �ؿ�뱸", "12-12")};
		String input; // �Է¹��� ����

		while (true) {
			// �ּ� �Է�
			System.out.print("�˻��� �ּ� �� ���� 2�ڸ�(��, ���Ḧ ���Ͻø� X�� �Է��Ͻÿ�) : ");
			input = sc.next();
			if (input.equalsIgnoreCase("x")) {
				System.out.println("���α׷� ����");
				break;
			}
			boolean searchOK = false;
			for (int idx = 0; idx < friends.length; idx++) {
				String address = friends[idx].getAddress();
				String address1 = address.substring(0, 2); // �ּ� �ձ��� �ΰ� �޾ƿ��� ����
				if (address1.equals(input)) {
					System.out.println(friends[idx]);
					searchOK = true;
				}
			} // for
			if(!searchOK) {
			System.out.println("�ش� �������� ��� ģ���� �����ϴ�.");
			break;
			} // if
		} // while

		sc.close();

	} // main

}
