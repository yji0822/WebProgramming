package com.lec.ex02_store;
// ���ǰ��� ����3ȣ��: ��ġ�-6,000  �δ��-7,000  �����-7,000 ���뱹-6,000
public class Store3 implements HeadQuaterStore {

	private String str;
	// ������
	public Store3(String str) {
		this.str = str;
	}
	
	// �Լ� �������̵�
	@Override
	public void kimchi() {
		System.out.println("��ġ� 6,000��");
	}
	@Override
	public void bude() {
		System.out.println("�δ�� 7,000��");
	}
	@Override
	public void bibib() {
		System.out.println("����� 7,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 6,000��");
	}

	@Override
	public void gonggibab() {
		System.out.println("����� 1,000��");
	}
	
	// getter
	public String getStr() {
		return str;
	}
	

}
