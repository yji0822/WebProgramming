package com.lec.ex;

public class VarEx05 {

	public static void main(String[] args) {
		boolean b = true; // ture or false �� ����
		char c = 'c';
		// �Ǽ����� ����Ҷ� ����!! - float�� ���� double���� ���� ����
		float f1;
		f1 = 10.1f; 
		// �Ǽ����� �⺻�� double��
		// ū���� double�� float�� �������� �ϸ� ���� �߻�
		// float ���� ���� ��, F or f�� ���־�� ��.
		System.out.println("f1=" + f1);
		f1 = 10.0000017f;
		double d = 10.0000017;
		System.out.println("f1 = " + f1); // f1 = 10.00002 �� �ݿø� ���
		System.out.println("d = " + d); // d = 10.0000017 �� �������
		// double�� ���ٰ� �����ϸ� ��, float�� ������. ���ں����� �Ǳ� ����
		
		f1 = 10.1f;
		d = 10.1;
		if (f1==d)
		{
			System.out.println("�� ������ ����");
		}
		else {
			System.out.println("�� ������ �ٸ���");
		}
		// '�� ������ �ٸ���' ��� ����� �ȴ�. float�� double ���ٰ� ������� ����!
		
	}

}
