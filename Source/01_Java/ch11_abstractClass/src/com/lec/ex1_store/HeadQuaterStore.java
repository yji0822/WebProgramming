package com.lec.ex1_store;

public abstract class HeadQuaterStore { // �߻�Ŭ����

	// ������
	private String str; // "����"

	// ������
	public HeadQuaterStore(String str) {
//		super(); - �Ƚᵵ object������ �޾ƿ´�
		this.str = str;
	}
	
	// �޼ҵ�
	// Ŭ���� �� �߻�޼ҵ尡 �ϳ� �̻��� �� : �߻� Ŭ����
	// �޼ҵ� ������ ���� ���� �Ǿ��ִ� �޼ҵ� : �߻� �޼ҵ� (��ӹ��� Ŭ�������� �������̵�)
	public abstract void kimchi(); // �޼ҵ� ������ ���� ���� �Ǿ��ִ� �޼ҵ� : �߻� �޼ҵ�
	public abstract void bude();
	public abstract void bibib();
	public abstract void sunde();
	public abstract void gonggibab();
	// hstore.kimchi(); - �Ұ�. �Լ� ȣ�� �Ұ���
	// HeadQuarterStore hstore = new HeadQuarterStore("����"); ��ü ���� �Ұ�
	
	// getter&setter
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	
}
