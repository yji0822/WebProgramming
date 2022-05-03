package com.lec.quiz;

public class Member {
	
	// 데이터
	private String name; // 이름
	private String tel; // 전화번호
	private String address; // 주소

	// 생성자
	// new Customer("홍길동, "010-9999-9999", "서울시 용산구");
	public Member() {} // 디폴트 생성자
	public Member(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + address;
	}

	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
