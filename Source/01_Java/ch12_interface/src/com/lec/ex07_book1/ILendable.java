package com.lec.ex07_book1;
// Book �۾��� (���� �ѱ� ��.)
public interface ILendable {
	public byte STATE_BORROWED = 1; // "���� ��"
	public byte STATE_NORMAL   = 0; // "���� ����"
	// static final ��� 
	public void checkOut(String borrower, String checkoutDate); // ���� �� �����ΰ� ������ �̿�
	public void checkIn(); // �ݳ�
	public void printState(); // ���������� ������� ���
	
	
}
