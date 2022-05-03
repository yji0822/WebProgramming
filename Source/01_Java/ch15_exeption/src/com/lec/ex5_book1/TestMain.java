package com.lec.ex5_book1;

import java.util.Date;

public class TestMain {

	public static void main(String[] args) {

		BookLib book1 = new BookLib("89a-01", "java", "ȫ�浿");
		BookLib book2 = new BookLib("89a-02", "dbms", "�̵��");
		System.out.println("1. å ����Ʈ");
		System.out.println(book1);
		System.out.println(book2);
		System.out.println("\n2. ���� ���� ===");
		try {
			book1.checkOut("�����"); // ����ó���� �Լ�. �ݵ�� main���� try-catch���ֱ�
		} catch (Exception e) {
			System.out.println(e.getMessage()); // �����޽��� ���
		} 
		System.out.println(book1);
		
		// ������ ����
		System.out.println("\n3. ������ 3�� 11�Ϸ� ����");
		book1.setCheckOutDate(new Date(122,2,11)); // �������� 3��11�Ϸ� ��¥ ����
		System.out.println(book1);
		try {
			book1.checkIn(); // ����ó���� �Լ�
		} catch (Exception e) {
			System.out.println("���ܸ޼��� : " + e.getMessage());
		} 

		
	} // main

}
