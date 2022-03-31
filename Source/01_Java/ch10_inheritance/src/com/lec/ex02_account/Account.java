package com.lec.ex02_account;
/* ������(�Ӽ�, �������(�ν��Ͻ�����))
 * ���¹�ȣ String accountNo, ������ String ownerName, �ܾ� int balance
 * ��� (�޼ҵ�)
 * ���� void deposit(int), ���� int withdraw(int), �ܾ���ȸ int infoPrint()
 */
public class Account {

	// ������
	private String accountNo; // ���¹�ȣ
	private String ownerName; // ������
	private int balance; // �ܾ�
	
	// ������
	public Account() {
	}
	public Account(String accountNo, String ownerName) { // ���°���, ���Ա�X
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.println(ownerName + "(" + accountNo + ")��, ���°��� �����մϴ�. �Աݱݾ��� �����ϴ�.");
	}
	public Account(String accountNo, String ownerName, int balance) { // ���°���, ���Ա�O
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName + "(" + accountNo +")��, ���°��� �Ϸ�." + balance + "�� �Ա� �Ϸ�.");
	}
	
	// �޼ҵ�- �Ա�, ���, ���
	public void deposit(int money) {
		if(money >= 0) {
			balance += money;
			System.out.println(ownerName + "(" + accountNo + ")��, " + money + "�� �Ա� �Ϸ�. �����ܾ�: " + balance + "��");
		} else {
			System.out.println(ownerName + "��?? �峭����");
		} // if
	} // deposit
	
	public void withdraw(int money) {
		if(money <= balance) {
			balance -= money;
			System.out.println(ownerName + "(" + accountNo + ")��" + money + "�� ���� �Ϸ�. �����ܾ�: " + balance + "��");
		} else {
			System.out.println(ownerName + "��, ��� �ܾ��� �����Ͽ� ������ �Ұ��մϴ�.");
		} //if		
	} // withdraw
	
	public String infoPrint() {
		return String.format("%s(%s)�� �ܾ�: %d��", ownerName, accountNo, balance);
	}
	
	// getter&setter
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
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}
