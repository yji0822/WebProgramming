package com.lec.ex5_book1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {

	// data
	private String bookNo; // å ��ȣ
	private String bookTitle; // å����
	private String writer; // ����
	private String borrower; // ������
	private Date   checkOutDate; // ������-�ý������κ��� �Է� �޴�.
	private byte   state; // ���Ⱑ��=1=STATED_BORROWED, ����Ұ���=0;
	
	// ������
	public BookLib(String bookNo, String bookTitle, String writer) {
//		super(); ������Ʈ Ŭ���������� ���� ������ ������ ���� ��
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	// method
	// BookLib book = new BookLib("89a-01", "java", "ȫ�浿");
	// book.checkOut("�ű浿"); : �������� Ȯ�� -> ������� -. �������� ���
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state == STATE_BORROWED) {
			throw new Exception(bookTitle + "������ ���� �� �Դϴ�."); 
			// error msg. ������ ���� �߻� - �ݵ�� try-catch ���־��
		}
		// ������� ���� - if���� ������� ���ϰ� ������ ������ ��
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		// "java" ������ ����Ǿ����ϴ�. ������: �ű浿 ������: 2022-04-04(��) 2�� �̳��� �ݳ��ϼ���. �޼��� ���
		// ��¥�� ���ϴ� ���·� ����ϱ� ���ؼ���...SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)"); // ������ ��� ���� �ͼ�������
		System.out.println("\"" + bookTitle + "\" ������ �١ڴ���١� �Ǿ����ϴ�.");
		System.out.println("������ : " + borrower + " / ������: " + sdf.format(checkOutDate) + " 2�� ���� �ݳ��ϼ���.");
	}
	
	// book.checkIn() : ��������Ȯ�� -> ��ü���� Ȯ��(��ü��) > if. ��ü�Ǿ��� ��� ��ü�� ���� y/n -> �ݳ����� -. ������� 
	// checkoutDate�� ���� ��¥�� �񱳸� �ؼ� 14�� ����; �ݳ� ���� / 14�� ����; ��ü�� �߻�
	@Override
	public void checkIn() throws Exception {
		if(state == STATE_NORMAL) {
			throw new Exception(bookTitle + "������ ���� ���� �ƴϿ���."); // ���ܸ޼��� �߻�
		}
		// ��ü���� Ȯ�� checkOutDate ~ ������� 14�� �̳����� Ȯ��
		// Ư���� ���� == checkOutDate
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime(); // ����������� ��������� millsec ���༭ ����Ⱓ Ȯ�� 
		long day = diff / (1000*60*60*24);
		// ��ü����
		if(day > 14) { // 14�� ��� (��ü), ��ü�� ���
			System.out.println("��ü��� ���� 100�� �ΰ��˴ϴ�.���ž� �� ��ü��� " + (day-14)*100 + "�� �Դϴ�.");
			Scanner sc = new Scanner (System.in); 
			// ��ü�� �ȵǸ� Scanner�� �ʿ��ϱ� ������ �̰��� �ۼ� - main�Լ����� �ݵ�� �ݾ�����
			System.out.print("��ü�Ḧ ���̳���? (Y/N) ");
			if(! sc.next().equalsIgnoreCase("y")) { // Y/y�� �Է����� ���� ���
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó���� �����մϴ�. ��ü�Ḧ ������.");
				return; // void�⶧���� �׳� return. ���� ȣ���� ������ ���ư��� �Ѵ�.
			}
		} 
		// �ݳ� ����
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "\" ������ �١ڹݳ��١ڵǾ����ϴ�.");
	}
	
	// sysout(book) -> å��ȣ:89a-01 å�̸�:java ����: ȫ�浿 ���� ����
	// 				-> å��ȣ:89a-01 å�̸�:java ����: ȫ�浿 ���� ��(������: 2022-04-04(��)) / �ݳ� ������:������¥ +14��
	@Override
	public String toString() {
		String msg = "å��ȣ: " + bookNo + "\tå�̸�: " + bookTitle + "\t����: " + writer; 
		msg += (state == STATE_NORMAL) ? "\t\"���� ����\"" : "\t\"���� ��\"";
		if(state == STATE_BORROWED) { // �ݳ� �������� ��� ���־�� �Ѵ�.
//			Date date = new Date(checkOutDate.getTime() + (1000*60*60*24*14)); // �ݳ�������
			SimpleDateFormat sdf = new SimpleDateFormat("(������ : yyyy-MM-dd(E))");
			msg += sdf.format(checkOutDate);
		}
		return msg;
	} // toString()


	// ������ ��¥ ����
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
}

