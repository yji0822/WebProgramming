package com.lec.ex2_date;

import java.util.GregorianCalendar;

public class Ex03_gc_term {

	public static void main(String[] args) {
		
		GregorianCalendar gcNow = new GregorianCalendar(); // ���� ������ ��¥�� �ð�
		GregorianCalendar gcThat = new GregorianCalendar(2022, 2, 11, 9, 30); // ���� ������ ��¥�� �ð� - 2�� 3��!
		// �ΰ��� ���� ���
		long start = gcThat.getTimeInMillis(); // 1970��~ ���� ���� ������ �и�����
		long end = gcNow.getTimeInMillis(); //1970��~ ���� ������ �и�����
		int day = (int)(end-start) / (1000*60*60*24); // 1000 ���� ��������.*60 �� ����������*60 ��ð��������� * 24 ���� ��������
		System.out.println("�����Ϻ��� ������� ���� ��������" + day);
		
	}

}
