package com.lec.ex6_member;
// (�ǽ�����4) Member Ŭ������ �����ϰ� �׽�Ʈ�Ͻð�
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;
	
	public Member() {}

	public Member(String id, String pw, String name, String email, String address, String birth, char gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	
	public String infoString() {
		return ("���̵� = " + id + "\n��й�ȣ = " + pw + "\n�̸� = " + name + "\n�̸��� = " + email 
				+ "\n�ּ� = " + address + "\n���� = " + birth + "\n���� = " + gender +"\n");
	} // ���
	

}
