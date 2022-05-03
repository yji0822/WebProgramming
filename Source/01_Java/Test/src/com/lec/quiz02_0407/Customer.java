package com.lec.quiz02_0407;
// (1) TestMain1.java에서, N이나 n을 입력할 때까지 회원가입 정보(이름, 전화번호, 주소)를 ArrayList에 받고, 
// N이나 n을 입력할 경우 가입한 모든 회원들의 정보를 아래와 같이 콘솔창과 text파일에 출력하는 프로그램을 구현하시오
// (2) TestMain2.java에서, N이나 n을 입력할 때까지 회원가입 정보(이름, 전화번호, 주소)를 HashMap에 받고, 
// N이나 n을 입력할 경우 가입한 모든 회원들의 정보를 아래와 같이 콘솔창에 출력하는 프로그램을 구현하시오
public class Customer {
	
	private String name; // 이름
	private String tel; // 번호
	private String address; // 주소
	
	// 생성자
	public Customer() {}
	public Customer(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	// method
	// 홍길동 010-9999-9999 서울시 용산구 용산동
	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + address + "\n";
	}
		

}
