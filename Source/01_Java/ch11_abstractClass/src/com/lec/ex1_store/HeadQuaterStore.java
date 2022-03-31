package com.lec.ex1_store;

public abstract class HeadQuaterStore { // 추상클래스

	// 데이터
	private String str; // "본사"

	// 생성자
	public HeadQuaterStore(String str) {
//		super(); - 안써도 object생성자 받아온다
		this.str = str;
	}
	
	// 메소드
	// 클래스 내 추상메소드가 하나 이상일 때 : 추상 클래스
	// 메소드 구현은 없고 선언만 되어있는 메소드 : 추상 메소드 (상속받은 클래스에서 오버라이드)
	public abstract void kimchi(); // 메소드 구현은 없고 선언만 되어있는 메소드 : 추상 메소드
	public abstract void bude();
	public abstract void bibib();
	public abstract void sunde();
	public abstract void gonggibab();
	// hstore.kimchi(); - 불가. 함수 호출 불가능
	// HeadQuarterStore hstore = new HeadQuarterStore("본사"); 객체 생성 불가
	
	// getter&setter
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	
}
