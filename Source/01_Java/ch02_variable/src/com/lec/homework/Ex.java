package com.lec.homework;

public class Ex {

	public static void main(String[] args) {
//		����, ����, ���� ������ ������ �Ҵ��ϰ� �� ������ ����ϰ� 
//		����, ��� ����ϴ� ���α׷� �����Ͻÿ�. 
//		(com.lec.homework ��Ű�� ���� �ۼ��� Ex.java�� 
//				yisy0703@naver.com���� ���Ϲ߼� �Ͻÿ�.)
		
		int kor = 100;
		int eng = 97;
		int math = 96; // �˾ƺ��� ���� ���� �������� ���� ���̴�.
		System.out.println("��������: " + kor + "\t ��������: " + eng + "\t ��������: " + math);
		System.out.printf("���������� %d��, ���������� %d��, ���������� %d���Դϴ�. \n", kor, eng, math);
		
		int tot = kor+eng+math;
		double avg = tot / 3.0; // �Ǽ��� ������ ����!
		
		System.out.println("����: " + tot +" ��");
		System.out.println("���: " + avg + " ��");
		
		System.out.printf("������ %d��, ����� %.f�� �Դϴ�.", tot,avg);
		
		/*
		double ���� = 99.9;
		double ���� = 97.8;
		double ���� = 96.6;
		
		double tot1 = ���� + ���� + ����;
		double avg1 = tot / 3.0;
		System.out.println("����: " + tot1 +" ��");
		System.out.println("���: " + avg1 + " ��");
		// �Ǽ��� ������ �� �̷��� ��������..!
		// �Ҽ��� ���ڸ����� ���� �� �ְ� �ϴ� ��� - �̰� ���߿� �ٸ� �Լ� �̿��ؼ�.
		 */

		

	}

}
