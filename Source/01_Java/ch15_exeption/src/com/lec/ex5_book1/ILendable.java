package com.lec.ex5_book1;

public interface ILendable {
	
	public static final byte STATE_BORROWED = 1; // å���� 1(������=����Ұ�) 0(���Ⱑ��)
	public byte STATE_NORMAL = 0; // ���� ����
	public void checkOut(String borrower) throws Exception; // �����θ� �Է� - ���ܴ� �ݵ�� �̰��� �Է�
	public void checkIn() throws Exception; // �ݳ��ߴµ� �ݳ��Ѵٰ� �ϸ� ����ó��
	
}
