package com.lec.ex14_account;
/* ������ (�Ӽ�, �������(�ν��Ͻ�����)) 
 * : ���¹�ȣ (accountNo: String), ������ (ownerName: String), �ܾ� (balance: long)	
 * ��� (�޼ҵ�) 
 * : �����ϴ� (void deposit(int)),�����ϴ� (int withdraw(int)), �ܾ���ȸ (long infoPrint() -getter?) 
 * Account a = new Account(); - ����Ʈ ������ 
 * Account a = new Account("100-1", "ȫ�浿");
 * 			 = new Account("100-2", "ȫ�浿", 20000)*/

public class Account {
	private String accountNo; // ���¹�ȣ
	private String ownerName; // ������
	private long balance; // �ܾ�
	
	// ������ �Լ� 3��
	public Account() {} // ����Ʈ ������
	public Account(String accountNo, String ownerName) { // ������ ���� : ������ �ʱ�ȭ
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s(%s)�� ���� ���� �����մϴ�. ���� �� �Ȱ��� ���̾��? \n", ownerName, accountNo);
	} // �ʱ� �Ա� �ݾ� �ȵ�� �� ����� ���� ���� ������
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s(%s)�� ���� ���� �Ϸ�. %d �� �Ա� �Ϸ�Ǿ����ϴ�. \n", 
				ownerName, accountNo, balance); // long Ÿ�Ե� %d�� �����ش�.
	} // ����, ������, �Աݱݾ� ������
	
	
	// �޼ҵ� deposit, withdraw, infoPrint
	public void deposit(int money) { // ������ ��� money�� ������ ����ó��
	// ������ �ݾ׸� �ֱ� ������ void
		if(money >= 0) {
			balance += money;
			System.out.printf("%s(%s)��, %d�� �Ա� �Ϸ� �Ǿ����ϴ�. ���� �ܾ�: %d \n",
								ownerName, accountNo, money, balance);
		} else {
			System.out.println("�峭����");
		}
	}
	public void withdraw(int money) {
		if(money <= balance) {
			balance -= money;
			System.out.printf("%s(%s)��, %d�� ��� �Ϸ� �Ǿ����ϴ�. ���� �ܾ�: %d \n",
					ownerName, accountNo, money, balance);
		} else {
			System.out.println(ownerName + " �� ��� �ܾ� �����Ͽ� ������ �Ұ��մϴ�.");
		} // if-else
	}
	public String infoPrint() { // ȫ�浿(100-1)�� �ܾ�: 1000��
		return String.format("%s(%s)�� �ܾ� : %d��", ownerName, accountNo, balance); // **
//		return ownerName + "("+ accountNo +")" +"�� �ܾ� : " + balance + "��";
	}
	
	
	// getter & setter
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}	
		
	

}
