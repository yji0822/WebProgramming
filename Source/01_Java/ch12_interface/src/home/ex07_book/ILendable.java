package home.ex07_book;
// Book �۾���
public interface ILendable {
	
	public byte STATE_BORROWED = 1; // ������
	public byte STATE_NORMAL = 0; // ���Ⱑ��
	// static final ���
	
	public void checkOut(String borrower, String checkoutDate); 
	// ���� �� �����ΰ� ���⳯¥ Ȯ��
	public void checkIn(); // �ݳ�
	public void printState(); // ���� ������ ������� ���

}
