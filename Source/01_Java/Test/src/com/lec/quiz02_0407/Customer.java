package com.lec.quiz02_0407;
// (1) TestMain1.java����, N�̳� n�� �Է��� ������ ȸ������ ����(�̸�, ��ȭ��ȣ, �ּ�)�� ArrayList�� �ް�, 
// N�̳� n�� �Է��� ��� ������ ��� ȸ������ ������ �Ʒ��� ���� �ܼ�â�� text���Ͽ� ����ϴ� ���α׷��� �����Ͻÿ�
// (2) TestMain2.java����, N�̳� n�� �Է��� ������ ȸ������ ����(�̸�, ��ȭ��ȣ, �ּ�)�� HashMap�� �ް�, 
// N�̳� n�� �Է��� ��� ������ ��� ȸ������ ������ �Ʒ��� ���� �ܼ�â�� ����ϴ� ���α׷��� �����Ͻÿ�
public class Customer {
	
	private String name; // �̸�
	private String tel; // ��ȣ
	private String address; // �ּ�
	
	// ������
	public Customer() {}
	public Customer(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	// method
	// ȫ�浿 010-9999-9999 ����� ��걸 ��굿
	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + address + "\n";
	}
		

}
