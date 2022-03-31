package com.lec.ex07_book2;

public class BookLib extends BookInfo implements ILendable {
	// String borrower
	// String checkoutDate
	// byte state(0,1)
	private String borrower; // ������
	private String checkOutDate; // ������ - ���߿� ��ü��¥ ����� �� �ֵ��� �ٲ� ��.
	private byte state; // ���� ���� �ʱ�ȭ���� �ʾұ� ������ �⺻ ���� '0'�̴�.
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}

	@Override
	public void checkOut(String borrower, String checkoutDate) {
		if (state == STATE_BORROWED) { // ���� Ȯ�� - ���� ���̸� �޼��� �Ѹ��� ���� �ߴ�
			System.out.println(borrower + "�Բ��� �����÷���" + getBookTitle() + " ������ ���� ���Դϴ�.");
			return;
		}
		// state�� 0�̶� ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkoutDate;
		state = STATE_BORROWED; // ���� �� ���·� ��ȯ
		System.out.println(getBookTitle() + "������ ���� ó�� �Ǿ����ϴ�.");
		System.out.println("������ : " + borrower + "\t ������ : " + checkoutDate);
	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "������ �ݳ� �Ϸ�� å�ε�.. �̻��մϴ�. ����ó��"); // ����ó��... ���߿�..
			return; // �ߴ�
		}
		// state == 1 (������)�̶� �ݳ� ����
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "������ �ݳ��� �Ϸ�Ǿ����ϴ�.");
	}

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookNo() + "\t " + getBookTitle() + " (" + getWriter() + "����) ���� ����");
		} else if (state == STATE_BORROWED) {
			System.out.println(getBookNo() + "\t " + getBookTitle() + " (" + getWriter()
			+ "����) ���� ��");
		} else {
			System.out.println(getBookNo() + "\t " + getBookTitle() + " (" + getWriter() + "����) �̻���");
		}
	}
	
	// getter & setter
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	
	

}
