package com.lec.ex12_store;
// ���а��� ����2ȣ��: �δ��-5,000  �����-5,000 �����-����
public class Store2 extends HeadQuaterStore {
	
	// ������
	public Store2(String str) {
		super(str);
	}
	
	// �޼ҵ� �������̵�
	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void bibib() {
		System.out.println("����� 5,000��");
	}
	@Override
	public void gonggibab() {
		System.out.println("����� ����");
	}
		
	
}
