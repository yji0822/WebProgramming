package com.lec.ex;

public class VarEx07 {

	public static void main(String[] args) {
		int i1 = 10; // 4byte
		long l1 = 2200000000L; // int ������ �ν��� �� ��� �ڿ� L�� �ٿ��ش�. 8byte
		
		// ���� byte���� ū byte��������
		double d1 = 10; // 8byte = 4byte - ���� / �������� ����ȯ
		System.out.println("d1 = " + d1); // 10.0 ��� - double������ ����ȯ
		
		double d2 = 10.19;
		// ū byte�� ���� byte�� �ְ� ������  �ٰ� �ִ� �ڸ��� �ִ�...
		// ������� ����ȯ (������ �ս��� �߻��� ���� ����)
//		int i2 = d2; // �����߻�
		int i2 = (int)d2;
		System.out.println("i2 = " + i2);

	}

}
