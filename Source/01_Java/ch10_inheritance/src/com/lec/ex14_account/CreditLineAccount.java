package com.lec.ex14_account;
// CreditLineAccount c2 = new CreditLineAccount("11-11", "ȫ", "1111-2222-3333-4444", 10000);
// CreditLineAccount c3 = new CreditLineAccount("11-11", "ȫ", 1000, "1111-2222-3333-4444", 10000);
public class CreditLineAccount extends CheckingAccount {

	private int creditLine; // ī���ѵ� 
	
	// ������
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	} // �ܾ��� 0���� ������
	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	} // �ܾ��߰��ϴ� ������
	
	// �������̵� �޼ҵ�
	@Override
	public void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) { // cardNo.equals(this.cardNo) �ص� ����
			if(creditLine >= amount) {
				creditLine -= amount; 
				System.out.printf("%s(%s)��, %d�� �����Ͽ� �ѵ� �ݾ� %d�� ���ҽ��ϴ�. \n"
						, getOwnerName(), getAccountNo(), amount, creditLine);
			} else {
				System.out.printf("%s(%s)�� ���� �ѵ� �ݾ� %d������ %d�� ���� �Ұ� �մϴ�. \n"
				, getOwnerName(), getAccountNo(), creditLine, amount);
			} // if-else �ѵ� ���
		} else {
			System.out.println("�ùٸ� ī�� ��ȣ�� �Է��ϼ���.");
		} // if-else ī���ȣ Ȯ��
	}

}
