package com.lec.ex;

import java.util.Scanner;

// (�ǽ����� 1-1) ����ڷκ��� ����, ö��, �浿, ����, ������ Ű�� �Է� �޾� ���Ű�� ���
// ����Ű� �ִܽ��� �������
// ������ �޾Ƴ��� ����ϴ� ���� �����Ѵ�..!
public class Ex05_avg {
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
		
		sc.close();
		
		// ���� 2) ������� �̸��� Ű, �ִܽ��� �̸��� Ű ���
		int minHeight = 999, minIdx = -1; // �ִܽ� Ű ���� ���� (ū ������ �ʱⰪ ����), index(��ġ) ����
		int maxHeight = 0, maxIdx = 0; // (���� 0�̳� -999����) ����� Ű�� index(��ġ) ����
		// maxIdx, minIdx �� ���� �ʱ�ȭ�� ����� if�� ���ư��� �񱳰� �����ϴ�.(���� �ʱ�ȭ�� -1�̳� 0���� ����)
		
		for(int i=0; i<arrName.length; i++) {
			if(arrHeight[i] < minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
			} // if - �ִܽ��� Ű�� index ã��
			if(arrHeight[i] > maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
			} // if - ������� Ű�� index ã��
		} // for
		System.out.printf("����� �л��� %s, Ű�� %d \n", arrName[maxIdx], maxHeight);
		System.out.printf("�ִܽ� �л��� %s, Ű�� %d \n", arrName[minIdx], minHeight);
		
		


		
	}

}
