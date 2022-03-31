package home.ex07_book;

public class BookLib extends BookInfo implements ILendable {
	
	private String borrower; // ������
	private String checkOutDate; // ������
	private byte state; // ������, ���Ⱑ��
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}

	@Override 
	public void checkOut(String borrower, String checkOutDate) { // ����
		if(state == STATE_BORROWED) {
			System.out.println(getBookTitle() + "������ ���� ���Դϴ�.");
			return;
		}
		// ����ó������
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(getBookTitle() + "������ ���� ó�� �Ǿ����ϴ�.");
		System.out.println("������ : " + borrower + "\t ������: " + checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "������ �ݳ��Ϸ�� å�ε� �̻��մϴ�. ���ܴ�!!!");
			return;
		}
		// state�� �������̶� �ݳ� ����
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "������ �ݳ� �Ϸ� �Ǿ����ϴ�.");
	}

	@Override
	public void printState() {
		if(state==STATE_NORMAL) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + "����) ���Ⱑ��");
		}else if(state==STATE_BORROWED) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + "����) ������");
		}else {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + "����) �̻���");
		}
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
