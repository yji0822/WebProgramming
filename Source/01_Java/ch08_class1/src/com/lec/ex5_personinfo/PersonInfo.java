package com.lec.ex5_personinfo;

public class PersonInfo {
	private String name;
	private int  age;
	private char gender;
	
	public PersonInfo() {}
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void print() {
		System.out.println("�̸�=" + name + ", ����=" + age + ", ����=" + gender);
		}
	

}
