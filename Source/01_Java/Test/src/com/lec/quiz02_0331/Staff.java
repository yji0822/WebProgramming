package com.lec.quiz02_0331;

public class Staff extends Person {

	private String department; // �μ�
	
	// ������
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	
	// �޼ҵ�
	@Override
	public String toString() {
		return super.toString() + " (�μ�) " + department;
	}
	
	// getter & setter
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	

}
