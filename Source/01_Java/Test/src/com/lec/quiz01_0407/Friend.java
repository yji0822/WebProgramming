package com.lec.quiz01_0407;
//[ 문I ] Friend 클래스형 객체 배열에 저장된 친구들의 주소 앞 글자 2자리로 친구를 검색하여, 
//존재하는 지역의 친구일 경우 친구의 전 정보를 출력하고, 
//존재하지 않는 지역의 친구일 경우 존재하지 않는 친구라고 출력하는 프로그램을 구현하시오(40점).
public class Friend {
	
	// 데이터
	private String name; // 이름
	private String phone; // 전화번호
	private String address; // 주소
	private String birthday; // 생일
	
	// 생성자
	public Friend() {}
	public Friend(String name, String phone, String address, String birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + "\n주소 : " + address 
				+ "\n핸드폰 : " + phone + "\n생일 : " + birthday;
		
	} // toString
	
	// getter&setter
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
