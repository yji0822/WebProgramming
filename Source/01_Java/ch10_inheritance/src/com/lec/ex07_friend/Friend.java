package com.lec.ex07_friend;
// this. : "�� ��ü��" a b...
// this() : �� Ŭ������ ������ �Լ�
public class Friend {
	// ������-������-�޼ҵ�-setter&getter
	private String name;
//	private int tel; // 01099999999 - 0�� �������
	private String tel; // 010-9999-9999 Friend f = new Friend("ȫ�浿", "010-9999-9999");
	
	// ������
	public Friend() {
		System.out.println("�Ű����� ���� ������ �Լ�");
	}
	public Friend(String name) {
		this();
		this.name = name;
		System.out.println("�Ű����� �ϳ�¥�� ������ �Լ�");
	}
	public Friend(String name, String tel) {
		this(name); // Friend(name) ȣ�� - �̹� name �����ڿ��� ȣ���� �߱� ������ �̷��� �ۼ����ش�!
		this.tel = tel;
		System.out.println("�Ű����� �ΰ�¥�� ������ �Լ�");
	}
	// this(); - ���� �� Ŭ������ ������ ȣ��
	
	
	// �޼ҵ�
	public String infoString() {
		return "[�̸�] " + name + ", [��ȭ] " + tel ;
	}
	
	

}
