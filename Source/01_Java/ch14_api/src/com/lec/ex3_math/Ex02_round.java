package com.lec.ex3_math;
// Math.ceil(�ø� �Ǽ���) => double��  return
// Math.round (�ݿø��� �Ǽ���) 9.5 > 10 => ������ return
// Math.floor (���� �Ǽ���) => double�� return
public class Ex02_round {

	public static void main(String[] args) {
		
		System.out.println("* �Ҽ������� �ݿø�, �ø�, ���� ����");
		System.out.println("9.15�� �ø�    : " + Math.ceil(9.15)); // double ��ȯ
		System.out.println("9.15�� �ø�    : " + (int)Math.ceil(9.15)); // �Ҽ������� �ø�
		System.out.println("9.15�� �ݿø� : " + Math.round(9.15));  // int ��ȯ
		System.out.println("9.15�� ����    : " + Math.floor(9.15));
		System.out.println("9.15�� ����    : " + (int)Math.floor(9.15));
		
		// �Ҽ��� ���° �ڸ����� �ݿø� �ϴ� ���
		System.out.println("\n* �Ҽ��� ù°�ڸ����� �ݿø�, �ø�, ���� ");
		System.out.println("9.15�� �ø�                              : " + Math.ceil(9.15)); // java api������ �Ҽ��� �ø� �Լ��� �������� �ʴ´�.
		System.out.println("9.15�� �Ҽ��� �ι�°���� �ø�    : " + Math.ceil(9.15*10)/10);
		System.out.println("9.15�� �ݿø�                           : " + Math.round(9.15));
		System.out.println("9.15�� �Ҽ��� �ι�°���� �ݿø� : " + Math.round(9.15*10)/10.0); // round�� �������� �������ֱ⶧���� 10.0 ���� �����־�� �Ѵ�.
		System.out.println("9.15�� ����                              : " + Math.floor(9.15));
		System.out.println("9.15�� �Ҽ��� �ι�°���� ����    : " + Math.floor(9.15*10)/10);
		
		// ���� �ڸ����� �ݿø�, �ø�, ����
		System.out.println("\n* ���� �ڸ����� �ݿø�, �ø�, ����");
		System.out.println("85�� �ø�    : " + Math.ceil(85/10.0)*10);
		System.out.println("85�� �ݿø� : " + Math.round(85/10.0)*10);
		System.out.println("85�� ����    : " + Math.floor(85/10.0)*10);
		
	}
	

}
