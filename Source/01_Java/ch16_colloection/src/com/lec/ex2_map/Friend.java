package com.lec.ex2_map;
import java.text.SimpleDateFormat;
// 4.�н����� - Ex02_FreindMap.java
// Friend f = new Friend("ȫ", "010-9999-9999");
// sysout(f) = ȫ�� ����ó 010-9999-9999, ����; 04�� 14�� -> toString()
import java.util.Date;

public class Friend {

	// ������
	private String name; // �̸�
	private String tel; // ��ȭ��ȣ
	private Date   birth; // ����
	
	// ������
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public Friend(String name, String tel, Date birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	
	// �޼ҵ�
	// sysout(f) = ȫ�� ����ó 010-9999-9999, ����; 04�� 14�� -> toString()
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat(" ����: MM�� dd��"); // ���ϴ� �������� ���
		if(birth != null) {
			return name + "�� ����ó : " + tel + sdf.format(birth);
		} else {
			return name + "�� ����ó : " + tel;
		} // if-else
	} // toString()
	
	
}
