package com.lec.ex07_book1;
// Book b = new Book("890��-101-1��", "java", "ȫ�浿")
public class Book implements ILendable {
	
	// ������
	private String bookNo; // å��ȣ 890��-101-1��
	private String bookTitle; // å����
	private String writer; // ����
	private String borrower; // ������
	private String checkOutDate; // ������ - ���߿� ��ü��¥ ����� �� �ֵ��� �ٲ� ��.
	private byte state; // ������(1=STATE_BORROWED) ���Ⱑ��(0=STATE_NORMAL)
	
	// ������
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null;
//		checkOutDate = null;
//		state = STATE_NORMAL == 0; // ���� ����
	}
	
	// b.checkOut("�ű浿", "03-23"); ������ : state(����) Ȯ���ؼ� ���� ���̸� ���� �ߴ� / ���� �����̸� ���� ó��
// 	@Override
//	public void checkOut(String borrower, String checkoutDate) {
//		if (state == STATE_BORROWED) { // ���� Ȯ�� - ���� ���̸� �޼��� �Ѹ��� ���� �ߴ�
//			System.out.println(borrower + "�Բ��� �����÷���" + bookTitle + " ������ ���� ���Դϴ�.");
//		} else { // ���� ó��
//			this.borrower = borrower;
//			this.checkOutDate = checkoutDate;
//			state = STATE_BORROWED; // ���� �� ���·� ��ȯ
//			System.out.println(bookTitle + "������ ���� ó�� �Ǿ����ϴ�.");
//			System.out.println("������ : " + borrower + "\t ������ : " + checkoutDate);
//		}
//	}
 	@Override
	public void checkOut(String borrower, String checkoutDate) {
		if (state == STATE_BORROWED) { // ���� Ȯ�� - ���� ���̸� �޼��� �Ѹ��� ���� �ߴ�
			System.out.println(borrower + "�Բ��� �����÷���" + bookTitle + " ������ ���� ���Դϴ�.");
			return;
		}
		// state�� 0�̶� ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkoutDate;
		state = STATE_BORROWED; // ���� �� ���·� ��ȯ
		System.out.println(bookTitle + "������ ���� ó�� �Ǿ����ϴ�.");
		System.out.println("������ : " + borrower + "\t ������ : " + checkoutDate);
	}

 	// b.checkIn() �ݳ� : state Ȯ���ؼ� ���� ���� (0)�̸� �޼��� �Ѹ��� �ߴ�, �������̸�(1) �ݳ� ����
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle + "������ �ݳ� �Ϸ�� å�ε�.. �̻��մϴ�. ����ó��"); // ����ó��... ���߿�..
			return; // �ߴ�
		}
		// state == 1 (������)�̶� �ݳ� ����
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "������ �ݳ��� �Ϸ�Ǿ����ϴ�.");
	}

	// å���� ��� b.printState() => 890��-101-1�� java(ȫ�浿 ��) ���� ��
	@Override
	public void printState() { // ���� �������� �ƴ��� ���� Ȯ��
		// 1
		if(state == STATE_NORMAL) {
			System.out.println(bookNo + "\t " + bookTitle + " (" + writer + "����) ���� ����");
		} else if (state == STATE_BORROWED) {
			System.out.println(bookNo + "\t " + bookTitle + " (" + writer + "����) ���� ��");
		} else {
			System.out.println(bookNo + "\t " + bookTitle + " (" + writer + "����) �̻���");
		}
		
		// 2 ���� ����! ���ϴ°� ����ϸ� ��
//		String msg = bookNo + "\t " + bookTitle + "(" + writer + "����)";
//		msg = msg + (state == STATE_NORMAL ? "���� ����" : (state==STATE_BORROWED) ? "���� ��" : "�̻���"); // state 
//		System.out.println(msg);
	}

	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
	


	
}
