package com.lec.ex02_dataStream;

public class Product {
	
	private String name;  // �̸�
	private int    price; // ����
	private int    ps;    // ���
	
	// ������
	public Product() {}
	public Product(String name, int price, int ps) {
		this.name = name;
		this.price = price;
		this.ps = ps;
	}
	// �޼ҵ�
	@Override
	public String toString() {
		return name + "\t" + price + "\t" + ps;
	}
	
	// setter - �Ű����� ���� �Ϳ��� ������ �����ϱ� ���ؼ� setter �߰�
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	
	
	
	
	
}
