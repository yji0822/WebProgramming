package com.lec.ex12_store;
// ���� ��ħ         : ��ġ�-5,000  �δ��-6,000  �����-6,000 ���뱹-5,000  �����-1,000��
public class HeadQuaterStore {
	// ������
	private String str; // "����"

	// ������
	public HeadQuaterStore(String str) {
//		super(); - �Ƚᵵ object������ �޾ƿ´�
		this.str = str;
	}
	
	// �޼ҵ�
	public void kimchi() {
		System.out.println("��ġ� 5,000��");
	}
	public void bude() {
		System.out.println("�δ�� 6,000��");
	}
	public void bibib() {
		System.out.println("����� 6,000��");
	}
	public void sunde() {
		System.out.println("���뱹 5,000��");
	}
	public void gonggibab() {
		System.out.println("����� 1,000��");
	}

	// getter&setter
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	
}
