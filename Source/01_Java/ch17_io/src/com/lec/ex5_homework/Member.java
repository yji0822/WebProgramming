package com.lec.ex5_homework;

public class Member {
	
	private String name; // �̸�
	private String tel; // ��ȣ
	private String birth; // ����
	private String address; // �ּ�
	
	public Member(String name, String tel, String birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + birth + "��\t " + address + "\n";
	} 
	
	
}
