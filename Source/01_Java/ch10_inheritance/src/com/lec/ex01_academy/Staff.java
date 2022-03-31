package com.lec.ex01_academy;

public class Staff extends Person {

	private static int num;
	private String department;
	
	// ������
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		++num;
		setNo("staff" + num);
	}
	
	// �޼ҵ�
	@Override
	public void print() {
		super.print();
		System.out.println("\t(�μ�) " + department);
	}

	// getter & setter
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}	
	

}
