package com.lec.ex;

public class Ex01 {

	public static void main(String[] args) {
		int i = 10; // ������ ����� �Բ� ���� �ʱ�ȭ
		
		// �� 1. �迭���� ����� ���ÿ� �ʱ�ȭ
		int[] iArr = {10, 20, 30, 40, 50}; // int �迭 Ÿ���̴�..! ��� �ǹ� // pdf ���� ����
		iArr[2] = 300; // ������ ����. �迭�� index�� ���� �����ϴ�. (0~4) ������ 0���� �����Ѵ�.
		// 0~4 : iArr.lenght-1 ����
		// for���� ������ ���� �����ϴ�
		for (int idx = 0; idx<iArr.length; idx++) { // 0���� iArr.length��ŭ �迭 ���
			System.out.println(iArr[idx]);
		} 
		// ctrl + d : ���� ����� - ���� ���ﶧ ����
		// AltŰ ������ ȭ��ǥ ���Ʒ��� ������ ���Ʒ��� �� ���� ����
		
		// �� 2. �迭 ���� ����� �迭 �޸� ���� Ȯ��
//		int j;
//		j = 20;
		System.out.println();
		// �迭 ���� Ȯ��
		int[] iArr2 = new int[5]; // 5��ŭ�� �迭 ũ�� ���� (�� �ѹ� ������ �迭 ũ��� ���� �Ұ�!!��)
		for (int idx = 0; idx<iArr2.length; idx++) {
			System.out.printf("iArr[%d] = %d \n", idx, iArr2[idx]);
		} // ���۷��������� �迭�� �ʱⰪ�� '0'���� ���õǾ� �ִ� ���� Ȯ���� �� ����.
		
		// �� ����
		System.out.println();
		iArr2[0] = 999;
		iArr2[1] = 888;
		for (int idx = 0; idx<iArr2.length; idx++) {
			System.out.printf("iArr[%d] = %d \n", idx, iArr2[idx]);
		}
		
		// ��3. �迭 ���� ����
		int[] iArr3;
		iArr3 = new int[3]; // �޸� ���� �Ҵ�, ���� 0���� �ʱ�ȭ(���۷��� ����)
		// iArr3[0]~iArr3[2] - 3��
		for (int idx=0; idx<iArr3.length; idx++) {
			System.out.printf("iArr3[%d] = %d \n", idx, iArr3[idx]);
		}
		
		// �Ϲ� for��  Ȯ�� for��
		
	}

}
