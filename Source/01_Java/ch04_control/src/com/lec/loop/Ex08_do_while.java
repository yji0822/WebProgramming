package com.lec.loop;

import java.util.Scanner;

// �ǽ����� �� Ű����κ��� ¦���� �Է��� ������ ���� �Է¹ް� ¦���� �Է��ϸ� �Էµ� ���� ����ϴ� ���α׷��� �����Ͻÿ�
public class Ex08_do_while {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner (System.in);
		
		do {
			System.out.print("¦���� �Է� �ϼ���: ");
			num = sc.nextInt();
		}while(num%2 != 0); // �����ݷ�!!! ������!!!
		// while�� ���� ��쿡�� ��� �ݺ����� ���ư�����..!!!
		System.out.print("�Է��Ͻ� ���� ¦�� " + num + "�Դϴ�.");
		
		sc.close();
		// ���ѹݺ����� ���� �ʵ��� ����!
	}

}
