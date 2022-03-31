package com.lec.ex10_customer;
// name, tel - Person
// hiredate(�Ի���)- String, department(�μ�)
// Staff s = new Staff("ȫ", "010", "2020-09-01", "������");
public class Staff extends Person {

	private String hiredate; // �Ի���
	private String department; // �μ�

	// ������
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}
	
	// sysout(s.infoString()) - [�̸�] ȫ [��ȭ] 010 [�Ի���] 2022-09-01 [�μ�]������
	@Override // ������̼� java.lang
	public String infoString() {
		return super.infoString() + " [�Ի���] " + hiredate + " [�μ�] " + department;
	}
	
	

}
