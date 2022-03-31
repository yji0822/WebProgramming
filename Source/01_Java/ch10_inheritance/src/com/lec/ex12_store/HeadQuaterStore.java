package com.lec.ex12_store;
// 본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public class HeadQuaterStore {
	// 데이터
	private String str; // "본사"

	// 생성자
	public HeadQuaterStore(String str) {
//		super(); - 안써도 object생성자 받아온다
		this.str = str;
	}
	
	// 메소드
	public void kimchi() {
		System.out.println("김치찌개 5,000원");
	}
	public void bude() {
		System.out.println("부대찌개 6,000원");
	}
	public void bibib() {
		System.out.println("비빔밥 6,000원");
	}
	public void sunde() {
		System.out.println("순대국 5,000원");
	}
	public void gonggibab() {
		System.out.println("공기밥 1,000원");
	}

	// getter&setter
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	
}
