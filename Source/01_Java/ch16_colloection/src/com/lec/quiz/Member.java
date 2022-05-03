package com.lec.quiz;

public class Member {
	
	// ������
	private String name; // �̸�
	private String tel; // ��ȭ��ȣ
	private String address; // �ּ�

	// ������
	// new Customer("ȫ�浿, "010-9999-9999", "����� ��걸");
	public Member() {} // ����Ʈ ������
	public Member(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + address;
	}

	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
