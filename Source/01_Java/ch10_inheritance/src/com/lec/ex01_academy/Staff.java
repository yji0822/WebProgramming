package com.lec.ex01_academy;

public class Staff extends Person {

	private static int num;
	private String department;
	
	// 积己磊
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		++num;
		setNo("staff" + num);
	}
	
	// 皋家靛
	@Override
	public void print() {
		super.print();
		System.out.println("\t(何辑) " + department);
	}

	// getter & setter
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}	
	

}
