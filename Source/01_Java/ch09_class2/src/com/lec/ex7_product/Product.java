package com.lec.ex7_product;

public class Product {
	
	private int serialNo; // ��ü ������ ��ȣ 101, 102, 103...  - acdl123kesd�̷��Ĥ���
	public static int count = 100; // ��ü�� �ϳ��� ������ų������ �ϳ��� �����ϵ��� ���� ��.
	
	// ������
	public Product() {
		serialNo = ++count; // ȣ����ڸ��� �ٷ� �ϳ� ���������ִ� ���
	}
	// �޼ҵ�
	public void infoPrint() {
		System.out.println("serialNo = " + serialNo + "\t �������� count = " + count);
	}
	
}
