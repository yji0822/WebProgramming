package com.lec.ex07_book2;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		
		System.out.println("0324 �ǽ�����_�������� ���α׷�");
		BookLib[] books = {new BookLib("890��-101-1��", "java", "ȫ�浿"),
						   new BookLib("110��-111-1��", "dbms", "�ű浿"),
					       new BookLib("110��-123-2��", "web", "���浿"),
						   new BookLib("770��-123-3��", "jsp", "��浿"),
						   new BookLib("110��-123-2��", "spring", "��浿") };
		
		Scanner sc = new Scanner (System.in);
		int fn; // ��ɹ�ȣ (1. ���� | 2. �ݳ� | 3. åList | 0. ����)
		int idx; // �����ϰų� �ݳ��Ϸ��� �� ��, ��ȸ�� å�� index - �ݺ������� ��ü����� ��ȸ �ȵȴ�
		String bTitle, borrower, checkOutDate; // ����ڿ��� ���� å �̸�, ������, ������
		do { // �ݵ�� �ѹ��� ����
			System.out.print("1. ���� | 2. �ݳ� | 3. åList | 0. ����  ");
			fn = sc.nextInt();
			switch(fn) {
			case 1:
				// ���� : 1. å �̸� �Է� 2.å ��ȸ  3.å���� Ȯ�� 4.������ �Է� 5.������ �Է� 6.���� �޼ҵ� 
				// 1. å�̸��Է�
				System.out.print("�����ϰ��� �ϴ� å �̸� : ");
				bTitle = sc.next(); // string �޴� �Լ� - ���⸦ ���Թ��� ���� / white-space �ձ����� ��Ʈ���� ����
				// 2.å��ȸ
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				// å �뿩 ���� ��ȸ for
				if(idx==books.length) {
					System.out.println("���� �������� ���� ���� �Դϴ�.");
				} else { // books[idx] ������ ���� ó��
					// 3. å���� Ȯ��
					if(books[idx].getState() == BookLib.STATE_BORROWED) { // ����Ұ� ����
						System.out.println("���� ���� ���� �����Դϴ�.");
					} else { // ���� ���� ����
						// 4. �������Է� 5. ������ �Է� 6. ���� �޼ҵ� ȣ��
						System.out.print("������ : ");
						borrower = sc.next();
						System.out.print("������ : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2: // �ݳ� : 1.å�̸� 2. å��ȸ 3. �ݳ�
				System.out.print("�ݳ��� å �̸� : ");
				bTitle = sc.next();
				// 2. å��ȸ
				// �ε����� �޾ƿ� �� �����Ƿ� Ȯ��for�� ����� ���� �ʴ´�.
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
				} else { // idx�� ã�� �� ��ġ
					// 3. �ݳ�
					books[idx].checkIn();
				}
				break;
			case 3: 
				System.out.println("å ����Ʈ�� ������ �����ϴ�.");
				for (BookLib b : books) {
					b.printState();
				}
				break;
				
			} // switch-case
		} while(fn!=0);
		System.out.println("BYE");

		
	} // main

} // class
