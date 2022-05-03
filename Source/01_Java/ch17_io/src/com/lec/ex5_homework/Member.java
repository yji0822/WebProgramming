package com.lec.ex5_homework;

public class Member {
	
	private String name; // 捞抚
	private String tel; // 锅龋
	private String birth; // 积老
	private String address; // 林家
	
	public Member(String name, String tel, String birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + birth + "积\t " + address + "\n";
	} 
	
	
}
