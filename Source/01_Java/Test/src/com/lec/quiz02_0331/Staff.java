package com.lec.quiz02_0331;

public class Staff extends Person {

	private String department; // 何辑
	
	// 积己磊
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	
	// 皋家靛
	@Override
	public String toString() {
		return super.toString() + " (何辑) " + department;
	}
	
	// getter & setter
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	

}
