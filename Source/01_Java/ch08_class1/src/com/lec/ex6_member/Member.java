package com.lec.ex6_member;
// (실습예제4) Member 클래스를 구현하고 테스트하시고
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
		return ("아이디 = " + id + "\n비밀번호 = " + pw + "\n이름 = " + name + "\n이메일 = " + email 
				+ "\n주소 = " + address + "\n생일 = " + birth + "\n성별 = " + gender +"\n");
	} // 출력
	

}
