package com.lec.ex;

import java.util.Scanner;

// (�ǽ����� 1) ����ڷκ��� ����, ö��, �浿, ����, ������ Ű�� �Է� �޾� ���Ű�� ���
// ������ �޾Ƴ��� ����ϴ� ���� �����Ѵ�..!
public class Ex05_minMax {
	public static void main(String[] args) {
		String[] arrName = {"����", "ö��", "�浿", "����", "����"}; // name[5] = "���"; - �����߻�
		int[] 	 arrHeight = new int[arrName.length]; // arrName ��ũ�⸸ŭ �Ҵ�
		Scanner sc = new Scanner(System.in);
		int totalHeight = 0; // 0���� �ݵ�� �ʱ�ȭ ���ֱ�. - �Է� ���� Ű ���� ����.
		
		for(int idx=0; idx<arrName.length; idx++) {
			System.out.print(arrName[idx] + "�� Ű��: ");
			arrHeight[idx] = sc.nextInt();
			totalHeight += arrHeight[idx];
		}
		// ��� Ű ���
		System.out.println("���Ű�� " + (double)totalHeight/arrName.length);
		
		// ����� ���
		
		
		// �ִܽ� ���

		
	}

}
